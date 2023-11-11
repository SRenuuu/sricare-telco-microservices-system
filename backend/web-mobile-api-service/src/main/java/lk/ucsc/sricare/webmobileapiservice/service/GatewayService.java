package lk.ucsc.sricare.webmobileapiservice.service;

import lk.ucsc.sricare.webmobileapiservice.dto.RegAccount;
import lk.ucsc.sricare.webmobileapiservice.dto.UserAccount;

public interface GatewayService {
    String putMessage(String msg);

    String status();

    public String register(RegAccount regAccount);
}