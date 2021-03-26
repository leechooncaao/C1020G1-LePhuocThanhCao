package com.examine.demo.service.impl;

import com.examine.demo.entity.Contract;
import com.examine.demo.repository.ContractRepository;
import com.examine.demo.repository.CustomerRespository;
import com.examine.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        LocalDate localDate = LocalDate.parse(date, formatter);

        return localDate.isAfter(LocalDate.now());
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public List<Contract> findAllByCustomer_NameContaining(String name) {
        return contractRepository.findAllByCustomer_NameContaining(name);
    }

    @Override
    public List<Contract> findAllByCustomer_NameContainingAndServiceType(String name, String serviceType) {
        return contractRepository.findAllByCustomer_NameContainingAndServiceType(name, serviceType);
    }

}
