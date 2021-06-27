package ch.tim.pizzashopv1.user.domain;

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
@Table(name = "PSO_USER_ROLES", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
@IdClass(UserRolesPK.class)
public class UserRoles {
    private String userCode;
    private String roleCode;
    private User userByCode;
    private Role roleByCode;

    public UserRoles() {
    }

    public UserRoles(String userCode, String roleCode) {
        this.userCode = userCode;
        this.roleCode = roleCode;
    }

    @Id
    @Column(name = "USER_CODE")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Id
    @Column(name = "ROLE_CODE")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserRoles that = (UserRoles) o;

        return new EqualsBuilder().append(userCode, that.userCode).append(roleCode, that.roleCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(userCode).append(roleCode).toHashCode();
    }

    @ManyToOne
    @JoinColumn(name = "USER_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public User getUserByCode() {
        return userByCode;
    }

    public void setUserByCode(User psoUserByUserCode) {
        this.userByCode = psoUserByUserCode;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_CODE", referencedColumnName = "CODE", nullable = false,insertable = false,updatable = false)
    public Role getRoleByCode() {
        return roleByCode;
    }

    public void setRoleByCode(Role psoRoleByRoleCode) {
        this.roleByCode = psoRoleByRoleCode;
    }
}
