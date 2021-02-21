package beverage;

import org.junit.Test;
import services.BeverageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeWrapperTest {
    @Test
    public void testGetCoffeeWrapperDescription() {
        Beverage beverage = new Coffee();
        assertEquals("COFFEE", beverage.getBeverageDescription());
    }

    @Test
    public void testGetCoffeeWrapperType() {
        Beverage beverage = new Coffee();
        assertEquals(BeverageType.COFFEE, beverage.getBeverageType());
    }

    @Test
    public void testSetCoffeeWrapperType() {
        Beverage beverage = new Coffee();
        beverage.setBeverageType(BeverageType.HOT_WATER);
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }


}
