package ch.tim.pizzashopv1.order.to;

import javax.validation.constraints.NotNull;

public class  OrderDetailDTO {

    private String pizzaCode;
    @NotNull(message = "PizzaName is required")
    private String pizzaName;
    @NotNull(message = "Quantity is required")
    private Integer quantity;
    private Float price;

    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
