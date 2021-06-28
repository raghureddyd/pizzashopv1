package ch.tim.pizzashopv1.order.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.common.exception.ApplicationException;
import ch.tim.pizzashopv1.order.to.OrderDTO;

import javax.validation.Valid;

public interface OrderService {

  SearchPaginationResult<OrderDTO> getOrderById(Long id) throws ApplicationException;

  OrderDTO saveOrder(@Valid OrderDTO orderDTO);
}
