package com.example.petadopt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.example.petadopt.club.dao")
public class PetadoptApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetadoptApplication.class, args);
    }

}
