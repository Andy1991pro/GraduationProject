package by.shevchenko.graduationproject.repository;

import by.shevchenko.graduationproject.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

}
