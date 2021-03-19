package com.furama_app.repository;

import com.furama_app.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByNameContaining(String name);

    @Query(value="select * " +
            "from employee e " +
            "join position p using(position_id) " +
            "join division d using(division_id) " +
            "join education_degree ed using(education_degree_id) " +
            "where concat(e.employee_name,e.employee_birthday, e.employee_id_card, e.employee_phone, e.employee_email, e.employee_address," +
            "p.position_name, d.division_name, ed.education_degree_name) like %?1%",
            nativeQuery = true)
    List<Employee> findAllInputTex(String keyword);
}
