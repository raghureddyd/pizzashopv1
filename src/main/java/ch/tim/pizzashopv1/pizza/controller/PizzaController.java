package ch.tim.pizzashopv1.pizza.controller;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.pizza.service.PizzaService;
import ch.tim.pizzashopv1.pizza.to.PizzaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//BASE_API_PATH
@RestController
@RequestMapping(value = "/api/v1")
public class PizzaController {

    private static final Logger log = LoggerFactory.getLogger(PizzaController.class);

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping(value = "/pizzas")
    public ResponseEntity<SearchPaginationResult<PizzaDTO>> getPizzas() {
        log.debug("REST request for getPizzas");
        return new ResponseEntity<>(this.pizzaService.getPizzas(), HttpStatus.OK);
    }

    @GetMapping(value = "/pizzas/{pizzacode}")
    public ResponseEntity<SearchPaginationResult<PizzaDTO>> getPizza(@PathVariable("pizzacode") String pizzaCode) {
        log.debug("REST request for getPizza");
        return new ResponseEntity<>(this.pizzaService.getPizza(pizzaCode), HttpStatus.OK);
    }
}
