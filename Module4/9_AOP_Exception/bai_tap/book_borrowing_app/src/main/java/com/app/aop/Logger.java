package com.app.aop;

import com.app.controller.BookController;
import com.app.model.Book;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    public static String bookName;



    @After("execution(* com.app.controller.BookController.borrowBook(*,*))")
    public void afterBorrowing(){
        LOGGER.info("Book: " + bookName + " had been borrowed !");
    }

    @After("execution(* com.app.controller.BookController.returnBook(*,*))")
    public void afterReturning(){
        LOGGER.info("Book: " + bookName + " had been return !");
    }


}
