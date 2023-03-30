package by.shevchenko.graduationproject.repository;

import by.shevchenko.graduationproject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
