package com.furama_app.repository;

import com.furama_app.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findAllByNameContaining(String name);
}
