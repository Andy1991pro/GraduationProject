package by.shevchenko.graduationproject.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean inStock;
    private int quantity;
    private double price;


    public void statusInStock() {
        if (quantity < 1) {
            this.inStock = false;
        } else {
            this.inStock = true;
        }
    }
}

