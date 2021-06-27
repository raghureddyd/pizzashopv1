package ch.tim.pizzashopv1.tracking.domain;

import ch.tim.pizzashopv1.order.domain.Order;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PSO_ORDER_TRACKING", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class OrderTracking {
    private Long id;
    private Long orderId;
    private String status;
    private boolean active;
    private String comments;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Order orderById;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ACTIVE")
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "UPDATED_ON")
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderTracking that = (OrderTracking) o;

        return new EqualsBuilder().append(id, that.id).append(orderId, that.orderId).append(status, that.status).append(active, that.active).append(comments, that.comments).append(createdOn, that.createdOn).append(updatedOn, that.updatedOn).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(orderId).append(status).append(active).append(comments).append(createdOn).append(updatedOn).toHashCode();
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false,insertable = false,updatable = false)
    public Order getOrderById() {
        return orderById;
    }

    public void setOrderById(Order orderById) {
        this.orderById = orderById;
    }
}
