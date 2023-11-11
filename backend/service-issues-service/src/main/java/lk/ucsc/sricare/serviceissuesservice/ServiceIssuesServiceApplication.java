package lk.ucsc.sricare.serviceissuesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableMongoRepositories
public class ServiceIssuesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceIssuesServiceApplication.class, args);
    }

}
