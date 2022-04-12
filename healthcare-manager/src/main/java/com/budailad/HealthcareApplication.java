package com.budailad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@MapperScan("com.budailad.dao")
public class HealthcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);
    }

}
