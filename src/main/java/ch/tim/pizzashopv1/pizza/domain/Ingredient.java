package ch.tim.pizzashopv1.pizza.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "PSO_INGREDIENT", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class Ingredient {
    private String code;
    private String name;
    private Double price;
    private Collection<PizzaIngredients> pizzaIngredients;

    @Id
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return new EqualsBuilder().append(code, that.code).append(name, that.name).append(price, that.price).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).append(name).append(price).toHashCode();
    }

    @OneToMany(mappedBy = "ingredientByCode")
    public Collection<PizzaIngredients> getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(Collection<PizzaIngredients> psoPizzaIngredientsByCode) {
        this.pizzaIngredients = psoPizzaIngredientsByCode;
    }
}
