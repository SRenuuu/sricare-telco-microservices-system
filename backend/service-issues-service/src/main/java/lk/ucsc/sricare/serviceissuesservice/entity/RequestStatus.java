package lk.ucsc.sricare.serviceissuesservice.entity;

/* RequestStatus - Represents current status of the request
    1. Pending - initial status when request is created
    2. Processing - status change from pending -> processing when customer-care accept request
    3. Resolved - status change from processing -> resoved when customer-care resolved the issue
    4. Rejected - status change from pending -> rejected when customer-care reject the request(when this happens remark should be added)
 */
public enum RequestStatus {
    PENDING,
    PROCESSING,
    RESOLVED,
    REJECTED
}
