package lk.ucsc.sricare.billingpaymentsservice.Controllers;

import lk.ucsc.sricare.billingpaymentsservice.Models.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/billing-payments/billing")
public class BillController {

    @GetMapping("/health")
    public APIResponse healthCheck() {
        return new APIResponse("Billing Service is up and running", true);
    }

}
