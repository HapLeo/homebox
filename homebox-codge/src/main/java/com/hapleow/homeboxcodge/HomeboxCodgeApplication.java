package com.hapleow.homeboxcodge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hapleow.homeboxcodge.dao"})
public class HomeboxCodgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeboxCodgeApplication.class, args);
    }

}
