package com.example.telcosystemservice.services;

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

    public TelcoService addTelcoService(TelcoService telcoService) {
        return telcoServiceRepository.save(telcoService);
    }

    public List<TelcoService> getAllTelcoServices() {
        return telcoServiceRepository.findAll();
    }
}
