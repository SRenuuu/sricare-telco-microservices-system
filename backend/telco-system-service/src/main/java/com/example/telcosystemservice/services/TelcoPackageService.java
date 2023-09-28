package com.example.telcosystemservice.services;

import com.example.telcosystemservice.models.TelcoPackage;
import com.example.telcosystemservice.repositories.TelcoPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelcoPackageService {

    private final TelcoPackageRepository telcoPackageRepository;

    public TelcoPackageService(TelcoPackageRepository telcoPackageRepository) {
        this.telcoPackageRepository = telcoPackageRepository;
    }

    public TelcoPackage addTelcoPackage(TelcoPackage telcoPackage) {
        return telcoPackageRepository.save(telcoPackage);
    }

    public List<TelcoPackage> getAllTelcoPackages() {
        return telcoPackageRepository.findAll();
    }
}
