package com.app.service.impl;

import com.app.model.BorrowManager;
import com.app.repository.BookBorrowRepository;
import com.app.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowRepository bookBorrowRepository;

    @Override
    public String getBorrowCode() {
        Random r = new Random( System.currentTimeMillis() );
        return String.valueOf(((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)));
    }

    @Override
    public void save(BorrowManager borrowManager) {
        bookBorrowRepository.save(borrowManager);
    }

    @Override
    public BorrowManager borrowCodeIsExist(String borrowCode) {
        List<BorrowManager> borrowManagerList = bookBorrowRepository.findAll();
        for(BorrowManager bm : borrowManagerList){
            if(borrowCode.equals(bm.getBorrowCode()))
                return bm;
        }
        return null;
    }


}
