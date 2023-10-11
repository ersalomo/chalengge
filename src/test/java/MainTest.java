import com.Model.Beverage;
import com.Model.Item;
import com.Model.Food;
import com.Main;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @Nested
    class AddOrderMethod {
        List<Item> orderedMenu;
        @BeforeEach
        void setOrderedMenu() {
            orderedMenu = Main.orderedMenu;
        }

        @AfterEach
        void setEmptyOrderedMenu() {
            orderedMenu.clear();
        }
         @Test
         @DisplayName("Should persistent add new ordered menu")
            void testAddOrder() {
            // Arrange
             String name = "Nasi Uduk";
             double price = 15.000;
            Item food = new Food(name, price);
            int qty = 2;
            // Act
            Main.addOrder(food, qty);
            // Assert
            assertEquals(1, orderedMenu.size());
            assertEquals(name, orderedMenu.get(0).name());
            assertEquals(price, orderedMenu.get(0).price());
            assertEquals(qty, orderedMenu.get(0).count());
        }
         @Test
         @DisplayName("Should persistent increase qty when ordered menu exists")
            void testAddQtyOrder() {
            // Arrange
             String name1 = "Nasi Uduk";
             double price1 = 15.000;
             int qty1 = 2;
             String name2 = "Nasi Kotak";
             double price2 = 18.000;
             int qty2 = 3;
             String name3 = "Fanta";
             double price3 = 10.000;
             int qty3 = 2;

            Item orderFood_1 = new Food(name1, price1);
            Item orderFood_2 = new Food(name2, price2);
            Item orderBev_3 = new Beverage(name3, price3);
            // Act
            Main.addOrder(orderFood_1, qty1);
            Main.addOrder(orderFood_2, qty2);
            Main.addOrder(orderBev_3, qty3);
            Main.addOrder(orderBev_3, qty3);

            int expectedQtyOrder3 = qty3 + qty3;
            // Assert
            assertEquals(name1, orderedMenu.get(0).name());
            assertEquals(price1, orderedMenu.get(0).price());
            assertEquals(qty1, orderedMenu.get(0).count());

            assertEquals(name2, orderedMenu.get(1).name());
            assertEquals(price2, orderedMenu.get(1).price());
            assertEquals(qty2, orderedMenu.get(1).count());

            assertEquals(name3, orderedMenu.get(2).name());
            assertEquals(price3, orderedMenu.get(2).price());
            assertEquals(expectedQtyOrder3, orderedMenu.get(2).count());
            assertEquals(3, orderedMenu.size());
        }
    }

    @Nested
    class IsYesMethod{

        @Test
        public void testIsYesWithY() {
            String input = "y\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner sc = new Scanner(System.in);
            boolean result = Main.isYes("Pilih y/n: ", sc);
            assertTrue(result);
        }

        @Test
        public void testIsYesWithN() {
            String input = "n\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner sc = new Scanner(System.in);
            boolean result = Main.isYes("Pilih y/n: ", sc);
            assertFalse(result);
        }

        @Test
        public void testIsYesWithInvalidInput() {
            String input = "invalid\ny\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner sc = new Scanner(System.in);
            boolean result = Main.isYes("Pilih y/n: ", sc);
            assertTrue(result);
        }
    }

    @Nested
    class ValidChosenNumber {

        @Test
        void mainMenuMethod() {
        }

        @Test
        @DisplayName("should persistent return boolean when given empty params")
        void testEmptyParam() {
            // Arrange
            Integer[] validNumber = {};
            int chosenNum = 0;
            // Act
            // Assert
            assertFalse(Main.validChosenNumber(validNumber, chosenNum));
        }
        @Test
        @DisplayName("should persistent return false when chosen number does not exists")
        void testNotFoundChoseNumber() {
            // Arrange
            Integer[] validNumber = {1,2,3,45,5,7};
            int chosenNum = 0;
            // Act
            // Assert
            assertFalse(Main.validChosenNumber(validNumber, chosenNum));
        }
        @Test
        @DisplayName("should persistent return true")
        void testExistsChosenNum() {
            // Arrange
            Integer[] validNumber = {1,2,3,45,5,7};
            int chosenNum = 2;
            // Act
            // Assert
            assertTrue(Main.validChosenNumber(validNumber, chosenNum));
        }
    }


    @Nested
    class SaveStructMethod {

        @Test
        void emptyFileName() {
            assertThrows(IOException.class, ()-> {
                Main.saveStruct(new ArrayList<>());
            });
        }

    }


    @Nested
    class GetErrorInputMsgMethod {

        @Test
        void validParam(){

        String msg = "Hallo apa kabar";
        String expectedString = String.format("==================================\n" +
                "%s \n" +
                "==================================", msg);
        expectedString +=  "\n" + "(Y) untuk lanjut" + "\n" +
                "(n) untuk keluar" + "\n";
        assertEquals(expectedString, Main.getErrorInputMsg(msg));

        }
        @Test
        void emptyString(){

        String msg = "";
        String expectedString = String.format("==================================\n" +
                "%s \n" +
                "==================================", msg);
        expectedString +=  "\n" + "(Y) untuk lanjut" + "\n" +
                "(n) untuk keluar" + "\n";
        assertEquals(expectedString, Main.getErrorInputMsg(msg));

        }
    }
}
