package dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingListAdminReq {
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalCalories;
    
    private BigDecimal totalPrice;
    
}
