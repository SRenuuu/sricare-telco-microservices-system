package lk.ucsc.sricare.webmobileapiservice.controller;


import lk.ucsc.sricare.webmobileapiservice.dto.RegAccount;
import lk.ucsc.sricare.webmobileapiservice.dto.UserAccount;
import lk.ucsc.sricare.webmobileapiservice.service.GatewayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usergateway")
public class ServiceController {
    private GatewayService gatewayService;

    @GetMapping("/status")
    public String statusCheck(){
        return "Server is running....";
    }

    @PostMapping("auth/register")
    //change the typo of ResponseEntity to UserAccount after calling register service api
    public ResponseEntity<RegAccount> register(@RequestBody RegAccount regAccount){
        regAccount.status = gatewayService.register(regAccount);
        regAccount.PrintAll();
        return new ResponseEntity<>(regAccount, HttpStatus.CREATED);
    }
}
