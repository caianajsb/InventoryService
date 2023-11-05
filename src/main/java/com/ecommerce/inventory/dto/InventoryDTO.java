package com.ecommerce.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDTO {

    private Long id;
    @NotBlank
    private String skuCode;
    @Min(0)
    private Integer quantity;
}
