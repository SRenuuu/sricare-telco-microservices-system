package lk.ucsc.sricare.webmobileapiservice.dto;

import lk.ucsc.sricare.webmobileapiservice.dto.model.Role;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//(id, nic, full_name, dob, email, address)
public class UserAccount {
    private UUID id;
    private String nic;
    private String name;
    private String email;
    private String password;

    private Role role;
}
