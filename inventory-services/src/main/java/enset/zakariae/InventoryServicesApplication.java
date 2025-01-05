package enset.zakariae;

import enset.zakariae.entities.inventory;
import enset.zakariae.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(new inventory(null,"Ordinateur",788,12));
            inventoryRepository.save(new inventory(null, "imprimante", 7800,299));

            inventoryRepository.findAll().forEach(
                    inventory -> {
                        System.out.println(inventory.toString());
                    }
            );};
    }
}
