package com.examine.demo.repository;

import com.examine.demo.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByCustomer_NameContaining(String name);

    List<Contract> findAllByCustomer_NameContainingAndServiceType(String name, String serviceType);
}
