package com.xingji.frameproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FrameprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrameprojectApplication.class, args);
    }

}
