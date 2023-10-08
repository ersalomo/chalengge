package ModelTest;

import org.example.Model.Beverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BeverageTest {

    @Test
    @DisplayName("should thrown an error when contructor is empty")
    void testBeverageConstructorEmpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Beverage("Jus Manggo", -1);
        });

    }
    @Test
    @DisplayName("success instantaite beverage contructor")
    void testBeverageConstructor(){
        Beverage beverage = new Beverage("Jus mangga", 2000.00);
        assertEquals("Jus mangga", beverage.name());
        assertEquals(2000.00, beverage.price());

    }
}
