package ch.tim.pizzashopv1.pizza.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.common.exception.ApplicationException;
import ch.tim.pizzashopv1.common.exception.MessageCode;
import ch.tim.pizzashopv1.pizza.dao.IngredientDAO;
import ch.tim.pizzashopv1.pizza.dao.PizzaDAO;

import ch.tim.pizzashopv1.pizza.domain.Ingredient;
import ch.tim.pizzashopv1.pizza.domain.Pizza;
import ch.tim.pizzashopv1.pizza.to.PizzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaDAO pizzaDAO;
    private IngredientDAO ingredientDAO;

    @Autowired
    public PizzaServiceImpl(PizzaDAO pizzaDAO, IngredientDAO ingredientDAO) {
        this.pizzaDAO = pizzaDAO;
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<PizzaDTO> getPizzas() {
        List<Pizza> pizzaList = pizzaDAO.findAll();

        List<PizzaDTO> pizzaDTOList = new ArrayList<>();

        for (Pizza pizza : pizzaList) {
            pizzaDTOList.add(maptoDTO(pizza));
        }
        return new SearchPaginationResult<>(pizzaDTOList.size(),pizzaDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<PizzaDTO> getPizza(String pizzaCode) {
        Optional<Pizza> pizzaOptional = pizzaDAO.findById(pizzaCode);
        Pizza pizza;
        SearchPaginationResult<PizzaDTO> result ;
        if(pizzaOptional.isPresent()) {
            pizza = pizzaOptional.get();
            PizzaDTO pizzaDTO = maptoDTO(pizza);
            result = new SearchPaginationResult<>(1, List.of(pizzaDTO));
        }else{
            throw new ApplicationException(MessageCode.NOT_FOUND, MessageCode.NOT_FOUND.getDescription());
        }
        return result;
    }

    private PizzaDTO maptoDTO(Pizza pizza) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setCode(pizza.getCode());
        pizzaDTO.setName(pizza.getName());
        pizzaDTO.setBasePrice(pizza.getBasePrice());
        List<Ingredient> ingredientsByPizzaCode = ingredientDAO.getIngredientsByPizzaCode(pizza.getCode());
        pizzaDTO.setIngredients(ingredientsByPizzaCode.stream().map(Ingredient::getName).collect(Collectors.joining(",")));
        return pizzaDTO;
    }
}
