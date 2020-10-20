package com.itqf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itqf.dao")
public class LogisticsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsBackApplication.class, args);
    }

}
