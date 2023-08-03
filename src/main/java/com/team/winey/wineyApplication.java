package com.team.winey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class wineyApplication {

    public static void main(String[] args) {
        SpringApplication.run(wineyApplication.class, args);
    }

}
