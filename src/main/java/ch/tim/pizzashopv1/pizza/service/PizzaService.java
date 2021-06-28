package ch.tim.pizzashopv1.pizza.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.pizza.to.PizzaDTO;

public interface PizzaService {

    SearchPaginationResult<PizzaDTO> getPizzas();

    SearchPaginationResult<PizzaDTO> getPizza(String pizzaCode);
}
