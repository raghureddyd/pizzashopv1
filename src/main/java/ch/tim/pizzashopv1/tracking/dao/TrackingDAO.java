package ch.tim.pizzashopv1.tracking.dao;



import ch.tim.pizzashopv1.tracking.domain.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingDAO extends JpaRepository<OrderTracking,Double> {


    List<OrderTracking> findOrderTrackingByOrderId(Long orderId);

    OrderTracking findOrderTrackingByOrderIdAndActive(Long orderId,boolean active);

    /*@Modifying(clearAutomatically = true)
    @Query("update OrderTracking ot set ot.active=0 , ot.updatedOn= where ot.id=:id")
    void updateOrderTrackingById(@Param("id") Long id);*/

}
