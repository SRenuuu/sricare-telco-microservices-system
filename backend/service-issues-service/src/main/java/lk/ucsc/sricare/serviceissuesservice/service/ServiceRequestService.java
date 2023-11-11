package lk.ucsc.sricare.serviceissuesservice.service;

import lk.ucsc.sricare.serviceissuesservice.entity.RequestStatus;
import lk.ucsc.sricare.serviceissuesservice.entity.ServiceRequest;
import lk.ucsc.sricare.serviceissuesservice.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceRequestService {
    ServiceRequestRepository serviceRequestRepository;

    @Autowired
    public ServiceRequestService(ServiceRequestRepository serviceRequest){
        this.serviceRequestRepository = serviceRequest;
    }

    public List<ServiceRequest> getAllRequests(){
        return serviceRequestRepository.findAll();
    }

    public ServiceRequest getById(String id){
        return serviceRequestRepository.findById(UUID.fromString(id));
    }

    public ServiceRequest create(ServiceRequest serviceRequest){
        return serviceRequestRepository.save(serviceRequest);
    }

    public List<ServiceRequest> getByUserID(String userId){
        return serviceRequestRepository.findByUserIdOrderByCreatedDateDesc(userId);
    }

    public List<ServiceRequest> getByStatus(RequestStatus status){
        return serviceRequestRepository.findByRequestStatusOrderByCreatedDate(status);
    }

    public ServiceRequest update(ServiceRequest serviceRequest){
        return serviceRequestRepository.save(serviceRequest);
    }

    public UUID delete(ServiceRequest serviceRequest){
        serviceRequestRepository.delete(serviceRequest);
        return serviceRequest.getId();
    }
}
