package com.ues21.fundacionsoles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class FundacionSolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundacionSolesApplication.class, args);
    }

}
