package com.management.repository;

import com.management.model.Customer;
import com.management.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
}
