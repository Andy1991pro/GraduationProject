package by.shevchenko.graduationproject.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = true)
    private BasketEntity basket;





}
