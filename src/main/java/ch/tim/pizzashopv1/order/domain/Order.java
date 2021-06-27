package ch.tim.pizzashopv1.order.domain;

import ch.tim.pizzashopv1.user.domain.User;
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
@Table(name = "PSO_ORDER", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class Order {
    private Long id;
    private String userCode;
    private LocalDateTime createdOn;
    private User userByCode;

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
    @Column(name = "CUSTOMER_CODE")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String customerCode) {
        this.userCode = customerCode;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Order psoOrder = (Order) o;

        return new EqualsBuilder().append(id, psoOrder.id).append(userCode, psoOrder.userCode).append(createdOn, psoOrder.createdOn).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(userCode).append(createdOn).toHashCode();
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public User getUserByCode() {
        return userByCode;
    }

    public void setUserByCode(User psoUserByCustomerCode) {
        this.userByCode = psoUserByCustomerCode;
    }
}
