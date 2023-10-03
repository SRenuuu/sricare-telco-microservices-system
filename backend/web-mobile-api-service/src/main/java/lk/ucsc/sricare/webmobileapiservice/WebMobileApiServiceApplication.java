package lk.ucsc.sricare.webmobileapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WebMobileApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebMobileApiServiceApplication.class, args);
	}

}
