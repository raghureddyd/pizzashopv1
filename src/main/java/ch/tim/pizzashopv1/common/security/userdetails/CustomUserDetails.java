package ch.tim.pizzashopv1.common.security.userdetails;

import ch.tim.pizzashopv1.user.domain.User;
import ch.tim.pizzashopv1.user.domain.UserRoles;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails extends User implements UserDetails {


    private static final long serialVersionUID = -5456973816660806109L;


    private final Collection<SimpleGrantedAuthority> authorities = new HashSet<>();

    private User user;

    public CustomUserDetails() {
        super();
    }

    public CustomUserDetails(User user) {
        super();
        if (user != null) {
            this.user = user;
            this.setCode(user.getCode());
            this.setPassword(user.getPassword());
            Collection<UserRoles> userRolesByCode = user.getUserRolesByCode();
            for (UserRoles userRolesL:userRolesByCode) {
                Set<String> userRoles = new HashSet<>();
                userRoles.add(userRolesL.getRoleByCode().getCode());
                authorities.add(new SimpleGrantedAuthority(userRolesL.getRoleByCode().getCode()));
            }

        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CustomUserDetails that = (CustomUserDetails) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(user, that.user).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(user).toHashCode();
    }
}
