package lk.ucsc.sricare.webmobileapiservice.controller;


import lk.ucsc.sricare.webmobileapiservice.service.GatewayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usergateway")

public class ServiceController {
    private GatewayService gatewayService;

    @GetMapping("/status")
    public String statusCheck(){
        return "Server is running....";
    }
}
