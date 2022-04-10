package com.quickdine.authentication.entity;

import com.quickdine.authentication.util.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String customerFirstName;

    private String customerLastName;

    private String emailId;

    @Enumerated(EnumType.STRING)
    private Provider provider;
}
