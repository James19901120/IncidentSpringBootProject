package org.example.incidentdemo;

import org.example.incidentdemo.controller.IncidentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class IncidentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentDemoApplication.class,args);
    }

}
