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
public class RegAccount {
    private String nic;
    private String full_name;
    private String dob ;
    private String email;
    private String address;
    private String password;
    public Integer statusCode ;
    public String status = "";

    public boolean CheckConstraints(){
        return email != null && password != null;
    }

    public void PrintAll(){
        System.out.println(nic);
        System.out.println(full_name);
        System.out.println(dob);
        System.out.println(email);
        System.out.println(address);
        System.out.println(password);
        System.out.println(status);
    }
}
