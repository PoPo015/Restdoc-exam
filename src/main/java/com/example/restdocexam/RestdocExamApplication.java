package com.example.restdocexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Size;

@Slf4j
@SpringBootApplication
public class RestdocExamApplication {

    public static void main(String[] args) {
        log.info(" > String application 시작.");

        SpringApplication.run(RestdocExamApplication.class, args);
    }

}
