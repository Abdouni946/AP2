package enset.zakariae.entities;


import enset.zakariae.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Entity @AllArgsConstructor @Data @NoArgsConstructor @ToString
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private Long customerID;

    @Transient
    private Customer customer;
}
