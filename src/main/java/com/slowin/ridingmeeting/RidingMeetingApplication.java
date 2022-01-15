package com.slowin.ridingmeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class RidingMeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RidingMeetingApplication.class, args);
    }

}
