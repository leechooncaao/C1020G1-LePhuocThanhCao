package com.examine.demo.service;

import com.examine.demo.entity.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    boolean isValidDate(String date);

    Contract findById(Integer id);

    void delete(Contract contract);

    List<Contract> findAllByCustomer_NameContaining(String name);

    List<Contract> findAllByCustomer_NameContainingAndServiceType(String name, String serviceType);


}
