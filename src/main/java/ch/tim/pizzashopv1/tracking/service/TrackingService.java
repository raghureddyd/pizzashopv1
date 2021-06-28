package ch.tim.pizzashopv1.tracking.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.tracking.to.TrackingDTO;

public interface TrackingService {

    SearchPaginationResult<TrackingDTO> getTrackingByOrderId(Long orderId);

    TrackingDTO saveTracking(TrackingDTO orderId);


}
