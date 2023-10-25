package lk.ucsc.sricare.webmobileapiservice.service.impl;

import lk.ucsc.sricare.webmobileapiservice.dto.RegAccount;
import lk.ucsc.sricare.webmobileapiservice.dto.UserAccount;
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

    @Override
    public String register(RegAccount regAccount) {
        //should include registration-service->registration_api call to register a user
        //return user token

        return "Registration successful ..";
    }


}
