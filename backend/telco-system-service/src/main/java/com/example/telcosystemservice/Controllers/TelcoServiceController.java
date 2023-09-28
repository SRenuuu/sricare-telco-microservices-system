package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.RegisterTelcoServiceRequest;
import com.example.telcosystemservice.models.TelcoService;
import com.example.telcosystemservice.repositories.TelcoServiceRepository;
import com.example.telcosystemservice.services.TelcoServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class TelcoServiceController {

    private final TelcoServiceService telcoServiceService;

    @Autowired
    public TelcoServiceController(TelcoServiceService telcoServiceService) {
        this.telcoServiceService = telcoServiceService;
    }


    @PostMapping("/add")
    public TelcoService addTelcoService(@RequestBody RegisterTelcoServiceRequest registerTelcoServiceRequest) {
        TelcoService telcoService = TelcoService.builder()
                .name(registerTelcoServiceRequest.getName())
                .price(registerTelcoServiceRequest.getPrice())
                .status(registerTelcoServiceRequest.getStatus())
                .build();

        return telcoServiceService.addTelcoService(telcoService);
    }

    @GetMapping("/view")
    public List<TelcoService> getAllTelcoServices() {
        return telcoServiceService.getAllTelcoServices();
    }

}
