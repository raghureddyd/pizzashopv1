package ch.tim.pizzashopv1.order.controller;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.common.exception.ApplicationException;
import ch.tim.pizzashopv1.order.service.OrderService;
import ch.tim.pizzashopv1.order.to.OrderDTO;
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

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<SearchPaginationResult<OrderDTO>> getOrdersById(@PathVariable Long id){
        log.debug("REST request for getOrdersById");
        return new ResponseEntity<>(this.orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.debug("REST request for createOrder");
        return new ResponseEntity<>(this.orderService.saveOrder(orderDTO), HttpStatus.CREATED);
    }
}
