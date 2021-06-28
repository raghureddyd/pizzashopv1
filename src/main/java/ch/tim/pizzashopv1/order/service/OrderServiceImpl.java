package ch.tim.pizzashopv1.order.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.common.exception.ApplicationException;
import ch.tim.pizzashopv1.common.exception.MessageCode;

import ch.tim.pizzashopv1.order.domain.Order;
import ch.tim.pizzashopv1.order.domain.OrderDetail;
import ch.tim.pizzashopv1.order.dao.OrderDetailDAO;
import ch.tim.pizzashopv1.order.dao.OrderDAO;

import ch.tim.pizzashopv1.order.to.OrderDTO;
import ch.tim.pizzashopv1.order.to.OrderDetailDTO;
import ch.tim.pizzashopv1.pizza.to.PizzaDTO;
import ch.tim.pizzashopv1.tracking.Status;
import ch.tim.pizzashopv1.tracking.dao.TrackingDAO;

import ch.tim.pizzashopv1.tracking.domain.OrderTracking;
import ch.tim.pizzashopv1.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    private TrackingDAO trackingDAO;


    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, OrderDetailDAO orderDetailDAO,  TrackingDAO trackingDAO) {
        this.orderDAO = orderDAO;
        this.orderDetailDAO = orderDetailDAO;
        this.trackingDAO = trackingDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<OrderDTO> getOrderById(Long id) throws ApplicationException {
        Optional<Order> optionalOrder = orderDAO.findById(id);
        var orderDTO = new OrderDTO();
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        Order order;
        User customer;
        SearchPaginationResult<OrderDTO> result;
        if(optionalOrder.isPresent()){
            order = optionalOrder.get();
            orderDTO.setId(order.getId());
            customer = order.getUserByCode();
            orderDTO.setCustCode(customer.getCode());
            orderDTO.setPhoneNumber(customer.getPhoneNumber());
            orderDTO.setCustName(customer.getFirstName()+ " "+customer.getLastName());
            orderDTO.setAddress(customer.getStreet()+ " "+ customer.getStreetNo()+ " "+customer.getPinCode());
            List<OrderDetail> orderDetailByOrderId = orderDetailDAO.getOrderDetailByOrderId(order.getId());
            orderDetailByOrderId.stream().forEach(src -> orderDetailDTOList.add(mapToDTO(src)));
            orderDTO.setOrderDetailDTOList(orderDetailDTOList);
            result = new SearchPaginationResult<OrderDTO>(1, List.of(orderDTO));
        }else{
            throw new ApplicationException(MessageCode.NOT_FOUND,MessageCode.NOT_FOUND.getDescription());
        }
        return result;
    }

    @Override
    @Transactional
    public OrderDTO saveOrder(OrderDTO orderDTO){
        //if(isValid(orderDTO)) {
            var order = new Order();
            order.setUserCode(orderDTO.getCustCode());
            order.setCreatedOn(LocalDateTime.now());
            order = orderDAO.save(order);
            Order finalOrder = order;

            List<OrderDetail> orderDetailList = orderDTO.getOrderDetailDTOList().stream().map(ordtl -> new OrderDetail(finalOrder.getId(), ordtl.getPizzaCode(),
                                                                                                                       ordtl.getQuantity()
              , ordtl.getPrice())).collect(Collectors.toList());
            orderDetailDAO.saveAll(orderDetailList);
            orderDTO.setId(order.getId());
            OrderTracking orderTracking = new OrderTracking();
            orderTracking.setOrderId(order.getId());
            orderTracking.setStatus(Status.RECEIVED.name());
            orderTracking.setCreatedOn(LocalDateTime.now());
            trackingDAO.save(orderTracking);
        //}

        return orderDTO;

    }

    private OrderDetailDTO mapToDTO(OrderDetail orderDetail){
        var orderDetailDTO = new OrderDetailDTO();
        //var pizza = pizzaDAO.getOne(orderDetail.getPizzaCode());
        orderDetailDTO.setPizzaCode(orderDetail.getPizzaCode());
        orderDetailDTO.setPizzaName(orderDetail.getPizzaByCode().getName());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPizzaByCode().getBasePrice()*orderDetail.getQuantity());
        return orderDetailDTO;//modelMapper.map(orderDetail,OrderDetailDTO.class);
    }

    private boolean isValid(OrderDTO orderDTO){
        /*if(StringUtils.isAnyBlank(orderDTO.getPhoneNumber())){
            throw new ApplicationException(MessageCode.FIELD_REQUIRED,MessageCode.FIELD_REQUIRED.getDescription(),"phone_number");
        }*/
        return true;
    }
}
