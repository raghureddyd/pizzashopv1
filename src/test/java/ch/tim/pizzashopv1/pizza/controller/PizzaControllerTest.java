package ch.tim.pizzashopv1.pizza.controller;

import ch.tim.pizzashopv1.common.BaseTest;
import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.pizza.service.PizzaService;
import ch.tim.pizzashopv1.pizza.to.PizzaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PizzaControllerTest extends BaseTest {

    @MockBean
    PizzaService pizzaService;

    @Test
    void getAllPizza() throws Exception {
        List<PizzaDTO> pizzaDTOList = List.of(
          new PizzaDTO("CHIC", 12.00f, "Chicago Pizza", "basil,beef,mozzarella,virgin olive oil"));
        when(pizzaService.getPizzas()).thenReturn(new SearchPaginationResult(1, pizzaDTOList));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pizzas")
                          .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
          .andExpect(jsonPath("$.data[0].code").value("CHIC"))
          .andExpect(jsonPath("$.data[0].base_price").value(12.00))
          .andExpect(jsonPath("$.data[0].name").value("Chicago Pizza"))
          .andExpect(jsonPath("$.data[0].ingredients").value("basil,beef,mozzarella,virgin olive oil"));

        verify(pizzaService, times(1)).getPizzas();
    }
}