package ch.tim.pizzashopv1.order.dao;

import ch.tim.pizzashopv1.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {


}
