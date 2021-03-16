package com.furama_app.repository;

import com.furama_app.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findByContract_Id(Integer id);
}
