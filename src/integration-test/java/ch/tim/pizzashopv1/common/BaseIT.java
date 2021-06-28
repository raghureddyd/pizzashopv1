package ch.tim.pizzashopv1.common;

import ch.tim.pizzashopv1.Pizzashopv1Application;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
  classes = Pizzashopv1Application.class)
@AutoConfigureMockMvc
public class BaseIT {
}
