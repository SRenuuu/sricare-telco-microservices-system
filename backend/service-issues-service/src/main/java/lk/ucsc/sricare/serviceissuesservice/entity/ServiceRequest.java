package lk.ucsc.sricare.serviceissuesservice.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
    ServiceRequest - Represents request for particular service
 */
@Document("servicerequests")
public class ServiceRequest {
    @Id
    private UUID id;

    @NotNull
    private String userId;

    // TODO: this type attribute should be replace with telco-service type
    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private RequestStatus requestStatus;

    @NotNull
    private Date createdDate;

    private List<RequestRemark> remarks;

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<RequestRemark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<RequestRemark> remarks) {
        this.remarks = remarks;
    }

    public ServiceRequest(){ }

    public ServiceRequest(UUID id, String userId, String type, String description, RequestStatus requestStatus, Date createdDate, List<RequestRemark> remarks) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.description = description;
        this.requestStatus = requestStatus;
        this.createdDate = createdDate;
        this.remarks = remarks;
    }
}

