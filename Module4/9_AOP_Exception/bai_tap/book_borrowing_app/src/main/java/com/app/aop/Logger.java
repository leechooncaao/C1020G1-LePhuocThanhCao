package com.app.aop;

import com.app.controller.BookController;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @After("execution(* com.app.controller.BookController.borrowBook(*,*))")
    public void afterBorrowing(){
        LOGGER.info("operation : borrow");
    }

    @After("execution(* com.app.controller.BookController.returnBook(*,*))")
    public void afterReturning(){
        LOGGER.info("operation : return");
    }


}
