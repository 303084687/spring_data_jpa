package com.zhidian.mam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by zhangjiming on 2017/6/22.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
