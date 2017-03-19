package id.ac.ui.cs.eaap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PspTugasAkhirApplication {

	public static void main(String[] args) {
		SpringApplication.run(PspTugasAkhirApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(){
    	return new RestTemplate();
    }
}
