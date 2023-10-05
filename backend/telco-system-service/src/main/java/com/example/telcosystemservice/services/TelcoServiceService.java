package com.example.telcosystemservice.services;

import com.example.telcosystemservice.dto.AnyResponse;
import com.example.telcosystemservice.models.TelcoService;
import com.example.telcosystemservice.repositories.TelcoServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelcoServiceService {

    private final TelcoServiceRepository telcoServiceRepository;

    public TelcoServiceService(TelcoServiceRepository telcoServiceRepository) {
        this.telcoServiceRepository = telcoServiceRepository;
    }

    public AnyResponse addTelcoService(TelcoService telcoService) {
        TelcoService telcoServiceNew = telcoServiceRepository.save(telcoService);
        return AnyResponse.builder().message("Service added successfully").data(telcoServiceNew).build();
    }

    public AnyResponse getAllTelcoServices() {
        List<TelcoService> telcoServices = telcoServiceRepository.findAll();
        return AnyResponse.builder().message("Found services").data(telcoServices).build();
    }
}
