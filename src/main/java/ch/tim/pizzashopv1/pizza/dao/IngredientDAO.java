package ch.tim.pizzashopv1.pizza.dao;


import ch.tim.pizzashopv1.pizza.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientDAO extends JpaRepository<Ingredient,String> {

    @Query("select i from  Ingredient i , PizzaIngredients pi where pi.pizzaCode=:code and i.code=pi.ingredientCode")
    List<Ingredient> getIngredientsByPizzaCode(@Param("code") String code);
}
