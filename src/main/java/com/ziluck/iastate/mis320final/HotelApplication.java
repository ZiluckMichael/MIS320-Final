package com.ziluck.iastate.mis320final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class HotelApplication {
    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        SpringApplication.run(HotelApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
