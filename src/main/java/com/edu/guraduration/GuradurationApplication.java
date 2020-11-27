package com.edu.guraduration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(
        basePackages = "com.edu.guraduration.*",
        sqlSessionFactoryRef = "sqlSessionFactory",
        annotationClass = Repository.class
)
public class GuradurationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuradurationApplication.class, args);
    }
}
