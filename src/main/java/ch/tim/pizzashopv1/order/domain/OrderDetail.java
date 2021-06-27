package ch.tim.pizzashopv1.order.domain;

import ch.tim.pizzashopv1.pizza.domain.Pizza;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PSO_ORDER_DETAIL", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    private Long orderId;
    private String pizzaCode;
    private Integer quantity;
    private Float price;
    private Order order;
    private Pizza pizza;

    public OrderDetail() {
    }

    public OrderDetail(Long orderId, String pizzaCode, Integer quantity, Float price) {
        this.orderId = orderId;
        this.pizzaCode = pizzaCode;
        this.quantity = quantity;
        this.price = price;
    }

    @Id
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "PIZZA_CODE")
    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }

    @Basic
    @Column(name = "QUANTITY")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "PRICE")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderDetail that = (OrderDetail) o;

        return new EqualsBuilder().append(orderId, that.orderId).append(pizzaCode, that.pizzaCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(orderId).append(pizzaCode).toHashCode();
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false,insertable = false,updatable = false)
    public Order getOrderById() {
        return order;
    }

    public void setOrderById(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "PIZZA_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public Pizza getPizzaByCode() {
        return pizza;
    }

    public void setPizzaByCode(Pizza psoPizzaByPizzaCode) {
        this.pizza = psoPizzaByPizzaCode;
    }
}
