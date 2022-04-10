package com.quickdine.authentication.controller;

import com.quickdine.authentication.entity.CustomerInfo;
import com.quickdine.authentication.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/authenticate")
public class CustomerLoginController {

    @Autowired
    private CustomerLoginService customerLoginService;

    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to my application";
    }

    @GetMapping("/Customers")
    public void saveUserDetails(@AuthenticationPrincipal OAuth2User user){
         customerLoginService.saveUserDetails(user);
    }
    @GetMapping("/AllCustomers")
    public List<CustomerInfo> getCustomerDetails(){
        return customerLoginService.getCustomerDetails();
    }
}
