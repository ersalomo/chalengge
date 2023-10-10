package ModelTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.Model.Food;
public class FoodTest {
    @Test
    @DisplayName("should success instatiant Food Class")
    void testFoodContructor() {
        Food food = new Food("Nasi Padang", 20000.00);
        assertEquals("Nasi Padang", food.name());
        assertEquals(20000.00, food.price());
    }
}
