package ch.tim.pizzashopv1.user.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserRolesPK implements Serializable {
    private String userCode;
    private String roleCode;

    @Column(name = "USER_CODE")
    @Id
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(name = "ROLE_CODE")
    @Id
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

        UserRolesPK that = (UserRolesPK) o;

        return new EqualsBuilder().append(userCode, that.userCode).append(roleCode, that.roleCode).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(userCode).append(roleCode).toHashCode();
    }
}
