package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.model.Inventory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    public Optional<Inventory> findBySkuCode(String skuCode);
    
    public List<Inventory> findBySkuCodeIn(List<String> skuCode);
    
}
