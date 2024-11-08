package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import dev.nmarulo.depensaapp.app.users.dtos.FindByIdUserRes;
import dev.nmarulo.depensaapp.commons.mapper.CommonMapper;

public final class UserMapper extends CommonMapper {
    
    private UserMapper() {
    }
    
    public static FindByIdUserRes.ShoppingList toFindByIdUserResShoppingList(final ShoppingList shoppingList) {
        final var shoppingListRes = new FindByIdUserRes.ShoppingList();
        
        shoppingListRes.setId(shoppingList.getId());
        shoppingListRes.setName(shoppingList.getName());
        
        return shoppingListRes;
    }
    
}
