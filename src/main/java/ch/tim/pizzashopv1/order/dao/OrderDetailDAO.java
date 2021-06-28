package ch.tim.pizzashopv1.order.dao;


import ch.tim.pizzashopv1.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    @Query("select od from OrderDetail od where od.id.orderId=:orderId")
    List<OrderDetail> getOrderDetailByOrderId(@Param("orderId") Long id);

}
