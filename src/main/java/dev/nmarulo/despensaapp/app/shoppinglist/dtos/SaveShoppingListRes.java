package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveShoppingListRes {
    
    private Long id;
    
    private String name;
    
}