package ch.tim.pizzashopv1.user.domain;

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
@Table(name = "PSO_ROLE", schema = "dbo", catalog = "PIZZASHOP_ONLINE")
public class Role {
    private String code;
    private String name;
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
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Role psoRole = (Role) o;

        return new EqualsBuilder().append(code, psoRole.code).append(name, psoRole.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(code).append(name).toHashCode();
    }

    @OneToMany(mappedBy = "roleByCode")
    public Collection<UserRoles> getUserRolesByCode() {
        return userRolesByCode;
    }

    public void setUserRolesByCode(Collection<UserRoles> psoUserRolesByCode) {
        this.userRolesByCode = psoUserRolesByCode;
    }
}
