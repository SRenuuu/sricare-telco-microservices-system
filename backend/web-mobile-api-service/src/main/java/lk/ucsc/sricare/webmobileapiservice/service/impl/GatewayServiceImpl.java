package lk.ucsc.sricare.webmobileapiservice.service.impl;

import lk.ucsc.sricare.webmobileapiservice.service.GatewayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GatewayServiceImpl implements GatewayService {
    @Override
    public String putMessage(String msg) {
        return null;
    }

    @Override
    public String status() {
        return null;
    }
}
