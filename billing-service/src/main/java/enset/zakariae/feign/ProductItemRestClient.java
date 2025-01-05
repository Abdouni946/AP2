package enset.zakariae.feign;

import enset.zakariae.model.Inventory;
import jakarta.ws.rs.QueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICES")
public interface ProductItemRestClient {
    @GetMapping("/inventories")
    PagedModel<Inventory> PageProducts();

    @GetMapping("/inventories/{id}")
    Inventory getProductById(@PathVariable("id") Long id);

}
