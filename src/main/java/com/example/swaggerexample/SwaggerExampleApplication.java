package com.example.swaggerexample;

import com.example.swaggerexample.model.Rhmperso;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Rhmperso.class)
@MapperScan("com.example.swaggerexample.mapper")
@SpringBootApplication

public class SwaggerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerExampleApplication.class, args);
    }
}
