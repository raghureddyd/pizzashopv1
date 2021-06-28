package ch.tim.pizzashopv1.pizza.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PizzaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    @JsonProperty("base_price")
    private Float basePrice;

    private String name;

    private String ingredients;

    public PizzaDTO() {
    }

    public PizzaDTO(String code, Float basePrice, String name, String ingredients) {
        this.code = code;
        this.basePrice = basePrice;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}