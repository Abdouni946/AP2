package enset.zakariae;

import enset.zakariae.entities.Customer;
import enset.zakariae.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "zakariae", "zakariae@gmail.com"));
            customerRepository.save(new Customer(null, "mohamed", "mohammed@gmail.com"));

            customerRepository.findAll().forEach(
                    customer -> {
                        System.out.println(customer.toString());
                    }
            );};
    }
}
