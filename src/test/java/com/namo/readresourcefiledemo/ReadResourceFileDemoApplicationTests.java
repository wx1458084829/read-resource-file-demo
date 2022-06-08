package com.namo.readresourcefiledemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;

@SpringBootTest
class ReadResourceFileDemoApplicationTests {

    @Test
    void readResource1() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("template/test.ftl");
        InputStream inputStream = classPathResource.getInputStream();
        System.out.println(classPathResource.getURL());
    }

    @Test
    void readResource2() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/test.ftl");
    }

    @Test
    void readResource3() {
        InputStream inputStream = this.getClass().getResourceAsStream("template/test.ftl");
    }

    /**
     * 这种只能在开发模式下面访问
     * @throws FileNotFoundException
     */
    @Test
    void readResource4() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:template/test.ftl");
        InputStream inputStream = new FileInputStream(file);
    }
}
