package com.furama_app.service.contract_detail;

import com.furama_app.model.contract.ContractDetail;
import com.furama_app.repository.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findByContract_Id(Integer id) {
        return contractDetailRepository.findByContract_Id(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}

