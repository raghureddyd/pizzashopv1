package ch.tim.pizzashopv1.pizza.dao;


import ch.tim.pizzashopv1.pizza.domain.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza,String> {


}
