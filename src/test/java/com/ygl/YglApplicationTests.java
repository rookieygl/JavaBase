package com.ygl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class YglApplicationTests {

    @Test
    void contextLoads() {

        URL resource = this.getClass().getResource("");
        ClassLoader classLoader = this.getClass().getClassLoader();

        URL resource1 = classLoader.getResource("");


        System.out.println(resource1.getPath());
        System.out.println(resource.getPath());

        String path = this.getClass().getClassLoader().getResource("application.yml").getPath();
        System.out.println(path);

        URL resource2 = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(resource2.getPath());
    }

}
