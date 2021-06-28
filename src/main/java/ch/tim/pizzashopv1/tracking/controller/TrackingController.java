package ch.tim.pizzashopv1.tracking.controller;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.tracking.service.TrackingService;
import ch.tim.pizzashopv1.tracking.to.TrackingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class TrackingController {

    private static final Logger log = LoggerFactory.getLogger(TrackingController.class);

    private final TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping(value = "/trackings/{orderId}")
    public ResponseEntity<SearchPaginationResult<TrackingDTO>> getTrackingByOrderId(@PathVariable Long orderId){
        log.debug("REST request for getTrackingByOrderId");
        return new ResponseEntity<>(this.trackingService.getTrackingByOrderId(orderId), HttpStatus.OK);
    }

    @PostMapping(value = "/trackings")
    public ResponseEntity<TrackingDTO> updateOrder(@RequestBody TrackingDTO trackingDTO) {
        log.debug("REST request for updateOrder");
        return new ResponseEntity<>(this.trackingService.saveTracking(trackingDTO),HttpStatus.OK);
    }
}
