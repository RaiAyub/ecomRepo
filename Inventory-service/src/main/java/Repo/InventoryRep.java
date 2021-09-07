package Repo;

import Model.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRep extends JpaRepository<Inventory, Integer> {
    Optional<Inventory>findInventoryIdBy(Integer id);

}
