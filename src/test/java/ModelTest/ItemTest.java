package ModelTest;

import com.Model.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemTest {

    @Test
    @DisplayName("should be thrown an error when trying to instantiate Food Class")
    void testItemEmptyConstructor() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new MockItem("", 100);
        }); assertThrows(IllegalArgumentException.class, ()-> {
            new MockItem("Goods", -1);
        });
    }

    @Test
     void testSetPriceMethod() {
        Item item = new MockItem("Test Item", 10.0);
        assertThrows(IllegalArgumentException.class, () -> {
            item.price((int) -5.0);
        });
    }
    @Test
    @DisplayName("should be success to set price")
     void testSetPrice() {
        // Arrange
        double price = 1_000.00;
        Item item = new MockItem("Test Item", price);
        // Act & Assert
        assertEquals(price, item.price());
        double expectedPrice = 2_000.00;
        item.price(expectedPrice);
        assertEquals(expectedPrice , item.price());
    }

    @Test
     void testSetEmptyNameMethod() {
        Item item = new MockItem("Test Item", 10.0);
        assertThrows(IllegalArgumentException.class, () -> {
            item.name("");
        });
    }
    @Test
     void testSetNameMethod() {
        Item mockItem = new MockItem("Initial name", 1000);
        String nameExpected = "My Name";
        mockItem.name(nameExpected);
        assertEquals(nameExpected,  mockItem.name());
    }

    @Test
     void testSetNegativeOrNullCount() {
        Item item = new MockItem("Test Item", 10.0); // Menggunakan subclass MockItem untuk pengujian
        assertThrows(IllegalArgumentException.class, () -> {
            item.count(-1);
        });
        assertThrows(NullPointerException.class, () -> {
            item.count(null);
        });
    }

    @Test
    @DisplayName("Success change count item")
    void testSetCount() {
        Item item = new MockItem("Jagung Bakar", 1_000.00);
        int initialCount = 1;
        assertEquals(initialCount , item.count());
        int expectedCount = 3;
        item.count(expectedCount);
        assertEquals(expectedCount , item.count());
    }
    @Test
    @DisplayName("should be success instantiate Food Class")
    void testItemConstructor() {
        Item food = new MockItem("Nasi Padang", 20000.00);
        assertEquals("Nasi Padang", food.name());
        assertEquals(20000.00, food.price());
        assertEquals(1, food.count());
    }

    private static class MockItem extends Item { // mocking
        MockItem(String name, double price) {
            super(name, price);
        }
    }
}
