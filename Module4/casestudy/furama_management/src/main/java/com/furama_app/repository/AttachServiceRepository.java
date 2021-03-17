package com.furama_app.repository;

import com.furama_app.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
    AttachService findByName(String name);
}
