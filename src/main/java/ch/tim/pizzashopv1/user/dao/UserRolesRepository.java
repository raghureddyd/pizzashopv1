package ch.tim.pizzashopv1.user.dao;

import ch.tim.pizzashopv1.user.domain.UserRoles;
import ch.tim.pizzashopv1.user.domain.UserRolesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesPK> {
}
