package com.zhidian.mam;

import com.zhidian.mam.jpa.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by zhangjiming on 16/9/1.
 */
@Component
@Slf4j
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Autowired
    private IDemoService demoService;

    @Override
    public void run(String... strings) throws Exception {
        log.info("CommandLineRunner.........");

//        log.info("Environment: "+JSON.toJSONString(environment));

        log.info("CommandLineRunner End");
    }
}
