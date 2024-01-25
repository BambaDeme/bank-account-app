package com.deme.ahmadou.customerservice;

import com.deme.ahmadou.customerservice.config.GlobalConfig;
import com.deme.ahmadou.customerservice.entities.Customer;
import com.deme.ahmadou.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
@RestController
@RefreshScope
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("Cheikh Ahmadou Bamba")
							.lastName("DEME")
							.email("deme.ahmadou@mail.com")
							.build(),
					Customer.builder()
							.firstName("Diana Birame")
							.lastName("DIABONG")
							.email("diabong.dianadbg@mail.com")
							.build(),
					Customer.builder()
							.firstName("Papa Sourakhatou")
							.lastName("DIENE")
							.email("diene.soura@mail.com")
							.build()
			);

			customerRepository.saveAll(customerList);
		};
	}

	@Value("${global.params.x}")
	private int x;

	@Value("${global.params.y}")
	private int y;

	@Value("${customer.params.x}")
	private int customerX;

	@Value("${customer.params.y}")
	private int customerY;

	@GetMapping("/config")
	public Map<String,Integer> config() {
		return Map.of("x",x,"y",y,"customer x",customerX,"customer y",customerY);
	}

	@Autowired
	private GlobalConfig globalConfig;
	@GetMapping("/globalConfig")
	public GlobalConfig globalConfig(){
		return globalConfig;
	}

}
