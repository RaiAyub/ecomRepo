package Services;

import Model.Inventory;
import Repo.InventoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.UserNotFoundException;

import java.util.List;

@Service
public class InventoryService {

  private final InventoryRep inventoryRep;

 @Autowired
public InventoryService (InventoryRep inventoryRep){
  this.inventoryRep = inventoryRep;
 }

public Inventory addInventory(Inventory inventory){
    return inventoryRep.save(inventory);
 }

 public List<Inventory> findAllInventory(){
     return inventoryRep.findAll();
 }

 public Inventory findById(Integer id) {
     return inventoryRep.findInventoryIdBy(id).orElseThrow(()-> new UserNotFoundException("Inventory Not found"));
 }

 public Inventory updateInventory(Inventory inventory){
     return inventoryRep.save(inventory);
 }

}
