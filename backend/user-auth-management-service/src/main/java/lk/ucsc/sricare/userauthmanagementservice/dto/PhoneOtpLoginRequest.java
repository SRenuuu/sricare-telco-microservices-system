package lk.ucsc.sricare.userauthmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneOtpLoginRequest {
    private String phone;
    private String otp;
}
