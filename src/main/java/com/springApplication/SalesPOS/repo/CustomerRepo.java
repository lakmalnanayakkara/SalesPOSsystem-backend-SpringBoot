package com.springApplication.SalesPOS.repo;

import com.springApplication.SalesPOS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByStateEquals(boolean activeState);
}
