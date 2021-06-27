package ch.tim.pizzashopv1.user.domain;

import ch.tim.pizzashopv1.order.domain.Order;
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
@Table(name = "PSO_USER", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class User {
    private String code;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String street;
    private Integer streetNo;
    private Integer pinCode;
    private Collection<Order> ordersByCode;
    private Collection<UserRoles> userRolesByCode;

    @Id
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "STREET_NO")
    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }

    @Basic
    @Column(name = "PIN_CODE")
    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder().append(code, user.code).append(password, user.password).append(phoneNumber, user.phoneNumber).append(firstName, user.firstName).append(lastName, user.lastName).append(street, user.street).append(streetNo, user.streetNo).append(pinCode, user.pinCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).append(password).append(phoneNumber).append(firstName).append(lastName).append(street).append(streetNo).append(pinCode).toHashCode();
    }

    @OneToMany(mappedBy = "userByCode")
    public Collection<Order> getOrdersByCode() {
        return ordersByCode;
    }

    public void setOrdersByCode(Collection<Order> ordersByCode) {
        this.ordersByCode = ordersByCode;
    }

    @OneToMany(mappedBy = "userByCode")
    public Collection<UserRoles> getUserRolesByCode() {
        return userRolesByCode;
    }

    public void setUserRolesByCode(Collection<UserRoles> userRolesByCode) {
        this.userRolesByCode = userRolesByCode;
    }
}
