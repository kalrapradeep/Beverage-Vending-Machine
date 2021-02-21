
package beverage;

import org.junit.Test;
import services.BeverageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotWaterWrapperTest {
    @Test
    public void testGetHotWaterWrapperDescription() {
        Beverage beverage = new HotWater();
        assertEquals("HOT_WATER", beverage.getBeverageDescription());
    }

    @Test
    public void testGetHotWaterWrapperType() {
        Beverage beverage = new HotWater();
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }

    @Test
    public void testSetHotWaterWrapperType() {
        Beverage beverage = new HotWater();
        beverage.setBeverageType(BeverageType.HOT_WATER);
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }


}
