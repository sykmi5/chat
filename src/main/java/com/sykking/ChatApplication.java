package com.sykking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ChatApplication {

    public static void main(String[] args) {
        System.out.println("111");
        SpringApplication.run(ChatApplication.class, args);
    }

}
