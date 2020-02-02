package net.sample.doctor.docapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"net.sample.doctor.docapp.*"})
@ComponentScan(basePackages = "net.sample.doctor.docapp")
public class DocappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocappApplication.class, args);
    }

}
