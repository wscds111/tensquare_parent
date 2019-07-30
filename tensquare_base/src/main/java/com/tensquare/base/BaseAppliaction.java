package com.tensquare.base;

import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaseAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(BaseAppliaction.class);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
