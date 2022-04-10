package com.quickdine.authentication.repository;

import com.quickdine.authentication.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLoginRepository extends JpaRepository<CustomerInfo,Long> {
}
