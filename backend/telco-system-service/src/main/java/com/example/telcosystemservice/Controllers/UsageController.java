package com.example.telcosystemservice.Controllers;

import com.example.telcosystemservice.dto.AddUsageRequest;
import com.example.telcosystemservice.models.Usage;
import com.example.telcosystemservice.services.VoiceDataUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsageController {

    private VoiceDataUsageService voiceDataUsageService;

    @Autowired
    public UsageController(VoiceDataUsageService voiceDataUsageService) {
        this.voiceDataUsageService = voiceDataUsageService;
    }
    @PostMapping("/use")
    public Usage addUsage(@RequestBody AddUsageRequest addUsageRequest) {
        return voiceDataUsageService.addUsage(addUsageRequest);
    }


}
