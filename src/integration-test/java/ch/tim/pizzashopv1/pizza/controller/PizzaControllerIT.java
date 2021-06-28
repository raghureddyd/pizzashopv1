package ch.tim.pizzashopv1.pizza.controller;

import ch.tim.pizzashopv1.common.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PizzaControllerIT extends BaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllPizzas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pizzas")
                          .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
          .andExpect(jsonPath("$.data[0].code").value("CHIC"))
          .andExpect(jsonPath("$.data[0].base_price").value(12.0))
          .andExpect(jsonPath("$.data[0].name").value("Chicago Pizza"))
          .andExpect(jsonPath("$.data[0].ingredients").value("basil,beef,mozzarella,virgin olive oil"));
    }
}
