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
@Table(name = "PSO_PIZZA", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class Pizza {
    private String code;
    private String name;
    private Float basePrice;
    private Collection<PizzaIngredients> pizzaIngredientsByCode;

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
    @Column(name = "BASE_PRICE")
    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pizza psoPizza = (Pizza) o;

        return new EqualsBuilder().append(code, psoPizza.code).append(name, psoPizza.name).append(basePrice, psoPizza.basePrice).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).append(name).append(basePrice).toHashCode();
    }


    @OneToMany(mappedBy = "pizzaByCode")
    public Collection<PizzaIngredients> getPizzaIngredientsByCode() {
        return pizzaIngredientsByCode;
    }

    public void setPizzaIngredientsByCode(Collection<PizzaIngredients> psoPizzaIngredientsByCode) {
        this.pizzaIngredientsByCode = psoPizzaIngredientsByCode;
    }
}
