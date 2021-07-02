package com.rgnews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.rgnews.mapper")
@SpringBootApplication
public class RGnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RGnewsApplication.class, args);
    }

}
