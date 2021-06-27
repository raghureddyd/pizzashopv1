package ch.tim.pizzashopv1.pizza.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PSO_PIZZA_INGREDIENTS", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
@IdClass(PizzaIngredientsPK.class)
public class PizzaIngredients {
    private String pizzaCode;
    private String ingredientCode;
    private Pizza pizzaByCode;
    private Ingredient ingredientByCode;

    @Id
    @Column(name = "PIZZA_CODE")
    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }

    @Id
    @Column(name = "INGREDIENT_CODE")
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

        PizzaIngredients that = (PizzaIngredients) o;

        return new EqualsBuilder().append(pizzaCode, that.pizzaCode).append(ingredientCode, that.ingredientCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(pizzaCode).append(ingredientCode).toHashCode();
    }

    @ManyToOne
    @JoinColumn(name = "PIZZA_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public Pizza getPizzaByCode() {
        return pizzaByCode;
    }

    public void setPizzaByCode(Pizza pizzaByCode) {
        this.pizzaByCode = pizzaByCode;
    }

    @ManyToOne
    @JoinColumn(name = "INGREDIENT_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public Ingredient getIngredientByCode() {
        return ingredientByCode;
    }

    public void setIngredientByCode(Ingredient ingredientByCode) {
        this.ingredientByCode = ingredientByCode;
    }
}
