package dev.nmarulo.despensa_app.app.pantry.shopping_list;

import dev.nmarulo.despensa_app.app.pantry.product_images.ProductImage;
import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensa_app.app.pantry.products.Product;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.*;
import dev.nmarulo.despensa_app.commons.mapper.CommonMapper;
import org.springframework.data.domain.Page;

public final class ShoppingListMapper extends CommonMapper {
    
    private ShoppingListMapper() {
    }
    
    public static FindAllShoppingListRes.ShoppingList toFindAllShoppingListResShoppingList(final ShoppingList entity) {
        var response = new FindAllShoppingListRes.ShoppingList();
        
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setTotalProducts(entity.getTotalProducts());
        response.setCreatedAt(entity.getCreatedAt());
        
        return response;
    }
    
    public static FindByIdProductShoppingListRest toFindByIdProductShoppingListRest(final ProductHasShoppingList productHasShoppingList) {
        final var response = new FindByIdProductShoppingListRest();
        final var product = productHasShoppingList.getProduct();
        final var unitType = productHasShoppingList.getUnitType();
        final var unitTypeRes = new FindByIdProductShoppingListRest.UnitTypeRes(unitType.getId(), unitType.getName());
        final var productImage = getFirtProductImage(product);
        
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        response.setImgUrl(productImage.getUrl());
        response.setUnitType(unitTypeRes);
        
        return response;
    }
    
    public static SaveShoppingListRes toSaveShoppingListRes(final ShoppingList save) {
        return new SaveShoppingListRes(save.getId(), save.getName());
    }
    
    public static UpdateShoppingListRes toUpdateShoppingListRes(final ShoppingList update) {
        return new UpdateShoppingListRes(update.getId(), update.getName());
    }
    
    public static FindAllShoppingListRes toFindAllShoppingListRes(final Page<ShoppingList> page) {
        return pageTo(page, FindAllShoppingListRes::new, ShoppingListMapper::toFindAllShoppingListResShoppingList);
    }
    
    public static FindByIdShoppingListRes toFindByIdShoppingListRes(final ShoppingList shoppingList) {
        final var response = new FindByIdShoppingListRes();
        
        response.setId(shoppingList.getId());
        response.setName(shoppingList.getName());
        response.setTotalProducts(shoppingList.getTotalProducts());
        response.setTotalPrice(shoppingList.getTotalPrice());
        
        return response;
    }
    
    public static FindByIdProductListRes toFindByIdProductListRes(final Page<ProductHasShoppingList> page) {
        return pageTo(page,
                      FindByIdProductListRes::new,
                      ShoppingListMapper::toFindByIdProductListResProductShoppingListRes);
    }
    
    private static FindByIdProductListRes.ProductListRes toFindByIdProductListResProductShoppingListRes(final ProductHasShoppingList productHasShoppingList) {
        final var response = new FindByIdProductListRes.ProductListRes();
        final var productRes = new FindByIdProductListRes.ProductListRes.ProductRes();
        final var unitTypeRes = new FindByIdProductListRes.ProductListRes.UnitTypeRes();
        final var unitType = productHasShoppingList.getUnitType();
        final var product = productHasShoppingList.getProduct();
        final var productImage = getFirtProductImage(product);
        
        unitTypeRes.setId(unitType.getId());
        unitTypeRes.setName(unitType.getName());
        
        productRes.setId(product.getId());
        productRes.setName(product.getName());
        productRes.setPrice(product.getPrice());
        productRes.setImgUrl(productImage.getUrl());
        
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setSelected(productHasShoppingList.isSelected());
        response.setProduct(productRes);
        response.setUnitType(unitTypeRes);
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        
        return response;
    }
    
    private static ProductImage getFirtProductImage(Product product) {
        return product.getProductImages()
                      .stream()
                      .toList()
                      .getFirst();
    }
    
}
