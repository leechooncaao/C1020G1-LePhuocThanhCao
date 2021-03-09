package com.app;

import com.app.aop.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
