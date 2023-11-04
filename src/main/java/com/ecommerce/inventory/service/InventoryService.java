package com.ecommerce.inventory.service;

import com.ecommerce.inventory.dto.InventoryDTO;
import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryService {
    private final InventoryRepository repository;
    
    @Transactional(readOnly = true)
    public List<InventoryDTO> isInStock(List<String> skuCode){        
        return repository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> 
                    InventoryDTO.builder()
                            .id(inventory.getId())
                            .skuCode(inventory.getSkuCode())
                            .quantity(inventory.getQuantity())
                            .build()
                ).toList();
    }

    public void updateInventories(List<InventoryDTO> inventoryDTOs) {
        List<Inventory> inventories =  inventoryDTOs.stream().map(inventory -> Inventory.builder()
                .id(inventory.getId())
                .quantity(inventory.getQuantity())
                .skuCode(inventory.getSkuCode())
                .build()
                ).toList();
        repository.saveAll(inventories);                
    }    
}
