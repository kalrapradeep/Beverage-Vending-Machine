
package beverage;

import org.junit.Test;
import services.BeverageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotMilkWrapperTest {
    @Test
    public void testGetHotMilkWrapperDescription() {
        Beverage beverage = new HotMilk();
        assertEquals("HOT_MILK", beverage.getBeverageDescription());
    }

    @Test
    public void testGetHotMilkWrapperType() {
        Beverage beverage = new HotMilk();
        assertEquals(BeverageType.HOT_MILK, beverage.getBeverageType());
    }

    @Test
    public void testSetHotMilkWrapperType() {
        Beverage beverage = new HotMilk();
        beverage.setBeverageType(BeverageType.HOT_WATER);
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }


}
