package Controller;

import Model.Inventory;
import Services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    public final InventoryService inventoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List <Inventory> inventory = inventoryService.findAllInventory();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory){
        Inventory newInventory = inventoryService.addInventory(inventory);
        return new ResponseEntity<>(newInventory, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Integer id){
        inventoryService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory){
        Inventory updateInventory = inventoryService.updateInventory(inventory);
        return new ResponseEntity<>(updateInventory, HttpStatus.OK);
    }


}
