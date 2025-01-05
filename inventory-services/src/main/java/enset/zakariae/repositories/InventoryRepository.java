package enset.zakariae.repositories;

import enset.zakariae.entities.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface InventoryRepository extends JpaRepository<inventory, Long> {
}
