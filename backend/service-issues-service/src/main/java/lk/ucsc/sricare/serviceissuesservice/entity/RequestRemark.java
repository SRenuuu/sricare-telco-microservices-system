package lk.ucsc.sricare.serviceissuesservice.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

/*
    RequestRemark - Represents individual remark given to specific service request
 */
public class RequestRemark {
    @Id
    private String id;
    private Date created_date;
    private String content;
}
