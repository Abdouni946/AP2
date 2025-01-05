package enset.zakariae.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import enset.zakariae.model.Inventory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private double quantity;
    private Long productID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Bill bill;
    @Transient
    private Inventory inventories;
}
