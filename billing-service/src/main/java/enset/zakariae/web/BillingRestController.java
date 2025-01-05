package enset.zakariae.web;

import enset.zakariae.entities.Bill;
import enset.zakariae.feign.CustomerRestClient;
import enset.zakariae.feign.ProductItemRestClient;
import enset.zakariae.model.Customer;
import enset.zakariae.model.Inventory;
import enset.zakariae.repositories.BillRepository;
import enset.zakariae.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping(path = "/bills/{id}")
    public Bill getBillById(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        return bill;
    }
}
