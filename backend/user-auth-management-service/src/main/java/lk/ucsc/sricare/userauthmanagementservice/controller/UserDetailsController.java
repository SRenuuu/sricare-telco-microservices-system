package lk.ucsc.sricare.userauthmanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-details")
@RequiredArgsConstructor
public class UserDetailsController {
    @GetMapping("/my")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/by-phone")
    public String getUserByPhone(@RequestParam("phone") String phone) {
        // Logic to fetch user details by phone
        return "User details for phone: " + phone;
    }
}
