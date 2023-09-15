package com.poly.edu.reponsitory;

import com.poly.edu.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByUsername(String username);
}