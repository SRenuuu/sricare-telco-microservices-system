package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.models.TelcoService;
import com.example.telcosystemservice.repositories.TelcoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telco-service")
public class TelcoServiceController {

    private final TelcoServiceRepository telcoServiceRepository;

    @Autowired
    public TelcoServiceController(TelcoServiceRepository telcoServiceRepository) {
        this.telcoServiceRepository = telcoServiceRepository;
    }


    @PostMapping("/add")
    public TelcoService addTelcoService(@RequestBody TelcoService telcoService) {
        return telcoServiceRepository.save(telcoService);
    }

    @GetMapping("/all")
    public List<TelcoService> getAllTelcoServices() {
        return telcoServiceRepository.findAll();
    }

}
