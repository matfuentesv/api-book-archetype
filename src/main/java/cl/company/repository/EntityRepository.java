package cl.company.repository;

import cl.company.model.EntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<EntityModel,Long> {
}
