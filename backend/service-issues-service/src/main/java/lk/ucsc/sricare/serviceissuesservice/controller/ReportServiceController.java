package lk.ucsc.sricare.serviceissuesservice.controller;
import jakarta.validation.Valid;
import lk.ucsc.sricare.serviceissuesservice.dto.PostRequestDTO;
import lk.ucsc.sricare.serviceissuesservice.entity.RequestStatus;
import lk.ucsc.sricare.serviceissuesservice.entity.ServiceRequest;
import lk.ucsc.sricare.serviceissuesservice.service.ServiceRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
    ServiceController - exposes endpoints at [domain-name]/report-request
        Available endpoints
            /report-request [GET] - Return all the requests which are type REPORT
            /report-request?userId=[userId] [GET] - Return all the request(type-REPORT) which associated with that userId
            /report-request?id=[id] [GET] - Return the request associated with that id
            /report-request [POST] - Create new request(initial type-PENDING)
            /report-request/[id]?type=[type] [PUT] - Update the status of the request
            /report-request/[id] [DELETE] - Delete specific request with the given id

 */
@RestController
public class ReportServiceController {
    ServiceRequestService serviceRequestService;

    public ReportServiceController(ServiceRequestService serviceRequestService){
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping("/report-request")
    public List<ServiceRequest> getAllRequests(){
        // Fetching all service requests from the database
        List<ServiceRequest> allRequests = serviceRequestService.getAllRequests();

        return allRequests;
    }

    @GetMapping("/report-request/{requestId}")
    public ServiceRequest getRequestById(@PathVariable String requestId){
        // Fetching service request from the db using id
        ServiceRequest request = serviceRequestService.getById(requestId);

        if(request == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report request not found");
        } else {
            return request;
        }
    }


    @PostMapping("/report-request")
    public ServiceRequest createRequest(@Valid @RequestBody PostRequestDTO body){
        UUID requestUUID = UUID.randomUUID();
        RequestStatus requestStatus = RequestStatus.PENDING;

        ServiceRequest serviceRequest = new ServiceRequest(requestUUID, body.getUser_id(), body.getType(), body.getDescription(), requestStatus, new Date(), null);

        ServiceRequest savedEntity = serviceRequestService.create(serviceRequest);

        return savedEntity;
    }

    @PatchMapping("/report-request/{id}")
    public ServiceRequest updateRequest(@PathVariable String id, @Valid @RequestBody PostRequestDTO body){
        ServiceRequest serviceRequest = serviceRequestService.getById(id);

        if(serviceRequest == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report request not found");
        }

        serviceRequest.setUserId(body.getUser_id());
        serviceRequest.setDescription(body.getDescription());
        serviceRequest.setType(body.getType());

        ServiceRequest updatedRequest = serviceRequestService.update(serviceRequest);

        return updatedRequest;
    }

    @DeleteMapping("/report-request/{id}")
    public UUID deleteRequest(@PathVariable String id){
        System.out.println(id);
        System.out.println();
        System.out.println();

        ServiceRequest serviceRequest = serviceRequestService.getById(id);

        if(serviceRequest == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report request not found");
        }

        UUID request_id = serviceRequestService.delete(serviceRequest);

        return request_id;
    }

}
