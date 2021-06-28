package ch.tim.pizzashopv1.tracking.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.common.util.DateFormatterUtils;
import ch.tim.pizzashopv1.tracking.dao.TrackingDAO;
import ch.tim.pizzashopv1.tracking.domain.OrderTracking;
import ch.tim.pizzashopv1.tracking.to.TrackingDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackingServiceImpl implements TrackingService {

    private TrackingDAO trackingDAO;

    @Autowired
    public TrackingServiceImpl(TrackingDAO trackingDAO) {
        this.trackingDAO = trackingDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<TrackingDTO> getTrackingByOrderId(Long orderId) {
        List<OrderTracking> orderTrackingList = trackingDAO.findOrderTrackingByOrderId(orderId);
        List<TrackingDTO> trackingDTOList = orderTrackingList.stream().map(this::mapToDTO).collect(Collectors.toList());
        return new SearchPaginationResult<>(trackingDTOList.size(),trackingDTOList);
    }

    @Override
    @Transactional
    public TrackingDTO saveTracking(TrackingDTO trackingDTO) {
        OrderTracking currentOrderTracking = trackingDAO.findOrderTrackingByOrderIdAndActive(trackingDTO.getOrderId(), true);
        OrderTracking orderTracking;
        if(currentOrderTracking != null && StringUtils.equals(trackingDTO.getStatus(),currentOrderTracking.getStatus())){
            orderTracking = mapToEntity(trackingDTO);
            orderTracking.setUpdatedOn(LocalDateTime.now());
        }else {
            currentOrderTracking.setActive(false);
            currentOrderTracking.setUpdatedOn(LocalDateTime.now());
            trackingDAO.save(currentOrderTracking);
            //New tracking status
            trackingDTO.setTrackId(null);
            orderTracking = mapToEntity(trackingDTO);
            orderTracking.setActive(true);
            orderTracking.setCreatedOn(LocalDateTime.now());
        }
        orderTracking = trackingDAO.save(orderTracking);

        return mapToDTO(orderTracking);
    }

    private TrackingDTO mapToDTO(OrderTracking orderTracking){
        TrackingDTO trackingDTO = new TrackingDTO();
        trackingDTO.setTrackId(orderTracking.getId());
        trackingDTO.setOrderId(orderTracking.getOrderId());
        trackingDTO.setStatus(orderTracking.getStatus());
        trackingDTO.setComments(orderTracking.getComments());
        trackingDTO.setUpdatedOn(DateFormatterUtils.formatLocalDateTime(orderTracking.getUpdatedOn(),DateFormatterUtils.DATE_TIME_PATTERN));
        return trackingDTO;
    }

    private OrderTracking mapToEntity(TrackingDTO trackingDTO){
        OrderTracking orderTracking = new OrderTracking();
        orderTracking.setId(trackingDTO.getTrackId());
        orderTracking.setOrderId(trackingDTO.getOrderId());
        orderTracking.setStatus(trackingDTO.getStatus());
        orderTracking.setComments(trackingDTO.getComments());
        return orderTracking;
    }
}
