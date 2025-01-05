package enset.zakariae.model;

import lombok.Data;

@Data
public class Inventory {
    private Long id;
    private String name;
    private double price;
    private double quantity;
}
