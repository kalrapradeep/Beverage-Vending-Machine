
package beverage;

import org.junit.Test;
import services.BeverageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GingerTeaWrapperTest {
    @Test
    public void testGetGingerTeaWrapperDescription() {
        Beverage beverage = new GingerTea();
        assertEquals("GINGER_TEA", beverage.getBeverageDescription());
    }

    @Test
    public void testGetGingerTeaWrapperType() {
        Beverage beverage = new GingerTea();
        assertEquals(BeverageType.GINGER_TEA, beverage.getBeverageType());
    }

    @Test
    public void testSetGingerTeaWrapperType() {
        Beverage beverage = new GingerTea();
        beverage.setBeverageType(BeverageType.HOT_WATER);
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }


}
