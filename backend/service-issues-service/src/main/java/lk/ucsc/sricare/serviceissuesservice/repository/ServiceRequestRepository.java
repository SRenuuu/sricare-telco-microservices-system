package lk.ucsc.sricare.serviceissuesservice.repository;


import lk.ucsc.sricare.serviceissuesservice.entity.RequestStatus;
import lk.ucsc.sricare.serviceissuesservice.entity.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
    ServiceRequest findById(UUID id);
    List<ServiceRequest> findByUserIdOrderByCreatedDateDesc(String userId);
    List<ServiceRequest> findByRequestStatusOrderByCreatedDate(RequestStatus status);
}
