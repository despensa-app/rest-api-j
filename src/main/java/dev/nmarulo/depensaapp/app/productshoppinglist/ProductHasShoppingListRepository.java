package dev.nmarulo.depensaapp.app.productshoppinglist;

import dev.nmarulo.depensaapp.app.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK>, JpaSpecificationExecutor<ProductHasShoppingList> {
    
    Optional<ProductHasShoppingList> findByShoppingList_IdAndShoppingList_UserAndProduct_Id(Integer shoppingListId,
                                                                                            User user,
                                                                                            Long productId);
    
    List<ProductHasShoppingList> findAllByShoppingList_IdAndShoppingList_UserAndProduct_IdIn(Long id,
                                                                                             User user,
                                                                                             List<Long> productsId);
    
    @Query(
        "SELECT p FROM ProductHasShoppingList p WHERE p.shoppingList.id = :id AND p.shoppingList.user = :user AND p.product.id IN :productsId AND p.unitType.id IN :unitTypesId")
    List<ProductHasShoppingList> findAllByShoppingListIdAndUserAndProductIdInAndUnitTypeIdIn(Long id,
                                                                                             User user,
                                                                                             List<Long> productsId,
                                                                                             List<Integer> unitTypesId);
    
}
