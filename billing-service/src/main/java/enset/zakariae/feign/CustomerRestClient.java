package enset.zakariae.feign;

import enset.zakariae.model.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.ws.rs.GET;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICES")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable(name = "id") Long id);
}
