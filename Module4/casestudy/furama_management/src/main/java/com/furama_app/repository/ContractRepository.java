package com.furama_app.repository;

import com.furama_app.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByStartDateBeforeAndEndDateAfter(String startDate, String endDate);

    List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String startDate, String endDate, String name);
}
