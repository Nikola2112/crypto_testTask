package com.binance.crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoTaskApplication.class, args);
    }

}
