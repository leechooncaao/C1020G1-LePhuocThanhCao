package com.furama_app.service.contract;

import com.furama_app.model.contract.Contract;
import com.furama_app.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfter(currentDate,currentDate);
    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String currentDate,  String name) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(currentDate, currentDate, name);
    }
}
