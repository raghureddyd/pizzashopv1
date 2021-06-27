package ch.tim.pizzashopv1.pizza.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PizzaIngredientsPK implements Serializable {
    private String pizzaCode;
    private String ingredientCode;

    @Column(name = "PIZZA_CODE")
    @Id
    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }

    @Column(name = "INGREDIENT_CODE")
    @Id
    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PizzaIngredientsPK that = (PizzaIngredientsPK) o;

        return new EqualsBuilder().append(pizzaCode, that.pizzaCode).append(ingredientCode, that.ingredientCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(pizzaCode).append(ingredientCode).toHashCode();
    }
}
