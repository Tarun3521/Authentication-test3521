package com.quickdine.authentication.service;

import com.quickdine.authentication.entity.CustomerInfo;
import com.quickdine.authentication.repository.CustomerLoginRepository;
import com.quickdine.authentication.util.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerLoginService {

    @Autowired
    private CustomerLoginRepository customerLoginRepository;


    public CustomerInfo saveUserDetails(OAuth2User user) {
        Map<String, Object> customerDetails = user.getAttributes();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerFirstName(String.valueOf(customerDetails.get("family_name")));
        customerInfo.setCustomerLastName(String.valueOf(customerDetails.get("given_name")));
        customerInfo.setEmailId(String.valueOf(customerDetails.get("email")));
        customerInfo.setProvider(Provider.GMAIL);
        
           return    customerLoginRepository.save(customerInfo);
  
   
    }

    public List<CustomerInfo> getCustomerDetails() {
       return customerLoginRepository.findAll();
    }
}
