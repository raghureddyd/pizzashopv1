package ch.tim.pizzashopv1.user.dao;

import ch.tim.pizzashopv1.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
