package by.shevchenko.graduationproject.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="table_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private double amountOfPurchases;
    private double discount;
    @OneToOne
    @JoinColumn
    private BasketEntity basket;

}
