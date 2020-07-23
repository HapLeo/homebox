package com.hapleow.homeboxcodge;

import com.hapleow.homeboxcodge.config.CodgeProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = {"com.hapleow.homeboxcodge.dao"})
@EnableConfigurationProperties(CodgeProperties.class)
public class HomeboxCodgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeboxCodgeApplication.class, args);
    }

}
