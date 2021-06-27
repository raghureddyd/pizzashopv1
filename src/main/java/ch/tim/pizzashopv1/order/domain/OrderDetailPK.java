package ch.tim.pizzashopv1.order.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderDetailPK implements Serializable {
    private Long orderId;
    private String pizzaCode;

    @Column(name = "ORDER_ID")
    @Id
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderDetailPK() {
    }

    public OrderDetailPK(Long orderId, String pizzaCode) {
        this.orderId = orderId;
        this.pizzaCode = pizzaCode;
    }

    @Column(name = "PIZZA_CODE")
    @Id
    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailPK that = (OrderDetailPK) o;

        return new EqualsBuilder().append(orderId, that.orderId).append(pizzaCode, that.pizzaCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(orderId).append(pizzaCode).toHashCode();
    }
}
