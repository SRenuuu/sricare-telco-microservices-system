package lk.ucsc.sricare.serviceissuesservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    ServiceController - exposes endpoints at [domain-name]/resolve-request
        Available endpoints

            /resolve-request [GET] - Return all the requests which are type REPORT
            /report-request?userId=[userId] [GET] - Return all the request(type-REPORT) which associated with that userId
            /report-request?id=[id] [GET] - Return the request associated with that id

 */
@RestController
@RequestMapping(value = "resolve-request")
public class ResolveServiceController {

}
