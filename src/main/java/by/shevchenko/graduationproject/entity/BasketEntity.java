package by.shevchenko.graduationproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="basket_user")
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeProduct;
    private String nameProduct;
    private Boolean availability;
    private double prise;

}
