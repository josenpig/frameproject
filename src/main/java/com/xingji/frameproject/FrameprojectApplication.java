package com.xingji.frameproject;

//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
//@EnableScheduling
//@EnableRabbit
public class FrameprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrameprojectApplication.class, args);
    }
}
