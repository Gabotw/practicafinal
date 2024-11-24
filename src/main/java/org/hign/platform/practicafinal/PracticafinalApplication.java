package org.hign.platform.practicafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PracticafinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticafinalApplication.class, args);
    }

}
