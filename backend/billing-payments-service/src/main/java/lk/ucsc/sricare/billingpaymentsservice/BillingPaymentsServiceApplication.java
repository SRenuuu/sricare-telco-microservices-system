package lk.ucsc.sricare.billingpaymentsservice;

import lk.ucsc.sricare.billingpaymentsservice.Models.APIResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/billing-payments")
public class BillingPaymentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingPaymentsServiceApplication.class, args);
    }

    @GetMapping("/health")
    public APIResponse healthCheck() {
        return new APIResponse("Billing, Payments Service is up and running", true);
    }

}
