package enset.zakariae;

import enset.zakariae.entities.Bill;
import enset.zakariae.entities.ProductItem;
import enset.zakariae.feign.CustomerRestClient;
import enset.zakariae.feign.ProductItemRestClient;
import enset.zakariae.model.Customer;
import enset.zakariae.model.Inventory;
import enset.zakariae.repositories.BillRepository;
import enset.zakariae.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient  productItemRestClient) {
        return args -> {
            Customer  customer = customerRestClient.findCustomerById(1L);
            Bill bill = billRepository.save(new Bill(null,new Date(),null, customer.getId(),null));
            System.out.println("*******************");
            PagedModel<Inventory> productPageModel = productItemRestClient.PageProducts();
            productPageModel.forEach(p->{
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+ (int)(Math.random()*100));
                productItem.setBill(bill);
                productItemRepository.save(productItem);
            });
        };
    }
}
