package xyz.saglow.exercise.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.saglow.exercise.spring.controller.DepthStorage;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/3
 */
@SpringBootApplication(scanBasePackageClasses = Application.class)
public class Application {
    public static void main(String[] args) throws UnsupportedEncodingException {

        SpringApplication.run(Application.class, args);
    }
}
