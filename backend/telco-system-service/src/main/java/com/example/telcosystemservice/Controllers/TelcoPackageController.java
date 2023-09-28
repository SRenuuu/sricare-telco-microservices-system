package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.ActivateTelcoPackageRequest;
import com.example.telcosystemservice.dto.RegisterTelcoPackageRequest;
import com.example.telcosystemservice.models.TelcoPackage;
import com.example.telcosystemservice.models.UserPackageActivation;
import com.example.telcosystemservice.services.TelcoPackageService;
import com.example.telcosystemservice.services.UserPackageActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class TelcoPackageController {
    private final TelcoPackageService telcoPackageService;
    private final UserPackageActivationService userPackageActivationService;

    @Autowired
    public TelcoPackageController(TelcoPackageService telcoPackageService, UserPackageActivationService userPackageActivationService) {
        this.telcoPackageService = telcoPackageService;
        this.userPackageActivationService = userPackageActivationService;
    }

    @PostMapping("/add")
    public TelcoPackage addTelcoService(@RequestBody RegisterTelcoPackageRequest registerTelcoPackageRequest) {
        TelcoPackage telcoPackage = TelcoPackage.builder()
                .serviceType(registerTelcoPackageRequest.getServiceType())
                .name(registerTelcoPackageRequest.getName())
                .price(registerTelcoPackageRequest.getPrice())
                .payType(registerTelcoPackageRequest.getPayType())
                .size(registerTelcoPackageRequest.getSize())
                .build();

        return telcoPackageService.addTelcoPackage(telcoPackage);
    }

    @GetMapping("/view")
    public List<TelcoPackage> getAllTelcoServices() {
        return telcoPackageService.getAllTelcoPackages();
    }


    @PostMapping("/activate")
    public UserPackageActivation activatePackage(@RequestBody ActivateTelcoPackageRequest activateTelcoPackageRequest) {
        return userPackageActivationService.activatePackage(activateTelcoPackageRequest);
    }
}
