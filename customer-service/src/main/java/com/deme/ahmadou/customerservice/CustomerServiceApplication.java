package com.deme.ahmadou.customerservice;

import com.deme.ahmadou.customerservice.entities.Customer;
import com.deme.ahmadou.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
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

}
