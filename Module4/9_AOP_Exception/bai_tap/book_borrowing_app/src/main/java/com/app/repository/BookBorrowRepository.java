package com.app.repository;

import com.app.model.BorrowManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowRepository extends JpaRepository<BorrowManager, Integer> {

}
