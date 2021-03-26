package com.examine.demo.repository;

import com.examine.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByNameContaining(String name);

}
