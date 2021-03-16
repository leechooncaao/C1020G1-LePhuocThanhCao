package com.furama_app.service.contract_detail;

import com.furama_app.model.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    List<ContractDetail> findByContract_Id(Integer id);
}
