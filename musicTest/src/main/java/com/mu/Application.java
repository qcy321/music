package com.mu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mu.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Max Memory: " + runtime.maxMemory() / (1024 * 1024));
        System.out.println("Total Memory: " + runtime.totalMemory() / (1024 * 1024));
        System.out.println("Free Memory: " + runtime.freeMemory() / (1024 * 1024));
        System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " MB");
    }
}
