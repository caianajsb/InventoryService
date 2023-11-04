/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.dto.InventoryDTO;
import com.ecommerce.inventory.service.InventoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce/inventories")
@RequiredArgsConstructor
public class InventoryController {
    
    private final InventoryService service;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDTO> isInStock(@RequestParam List<String> skuCode){
        return service.isInStock(skuCode);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateInventories(@RequestBody List<InventoryDTO> inventories){
        service.updateInventories(inventories);
        return "Inventories updated sucessfully";
    }
}
