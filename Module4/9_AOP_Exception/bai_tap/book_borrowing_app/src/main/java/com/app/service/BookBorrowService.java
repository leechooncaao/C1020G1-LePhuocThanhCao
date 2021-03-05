package com.app.service;

import com.app.model.BorrowManager;

public interface BookBorrowService {
    String getBorrowCode();

    void save(BorrowManager borrowManager);

    BorrowManager borrowCodeIsExist(String borrowCode);
}
