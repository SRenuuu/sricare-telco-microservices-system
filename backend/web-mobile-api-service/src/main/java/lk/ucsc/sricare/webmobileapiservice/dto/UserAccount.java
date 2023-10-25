package lk.ucsc.sricare.webmobileapiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//(id, nic, full_name, dob, email, address)
public class UserAccount {
    private long id;
    private String nic;
    private String full_name;
    private Date dob ;
    private String email;
    private String address;
}
