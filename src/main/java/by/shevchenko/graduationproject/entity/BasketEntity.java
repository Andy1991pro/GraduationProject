package by.shevchenko.graduationproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="basket")

public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amountOfPurchases;
    private double discount;
    private double discountSum;
    @ManyToMany
    private List<ProductEntity> products;

public void discountAdd(){

    if (amountOfPurchases>=5000){
        discount=amountOfPurchases/100*5;
    }
    if(amountOfPurchases>=8000){
        discount=amountOfPurchases/100*8;
    }
}
public void sumCorrection(){
    discountSum=amountOfPurchases-discount;
}
}
