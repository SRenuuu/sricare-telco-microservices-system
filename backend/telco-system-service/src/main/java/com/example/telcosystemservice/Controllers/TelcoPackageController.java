package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.models.TelcoPackage;
import com.example.telcosystemservice.models.TelcoService;
import com.example.telcosystemservice.repositories.TelcoPackageRepository;
import com.example.telcosystemservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telco-package")
public class TelcoPackageController {
    private final TelcoPackageRepository telcoPackageRepository;

    @Autowired
    public TelcoPackageController(TelcoPackageRepository telcoPackageRepository) {
        this.telcoPackageRepository = telcoPackageRepository;
    }

    @PostMapping("/add")
    public TelcoPackage addTelcoService(@RequestBody TelcoPackage telcoPackage) {
        return telcoPackageRepository.save(telcoPackage);
    }

    @GetMapping("/all")
    public List<TelcoPackage> getAllTelcoServices() {
        return telcoPackageRepository.findAll();
    }
}
