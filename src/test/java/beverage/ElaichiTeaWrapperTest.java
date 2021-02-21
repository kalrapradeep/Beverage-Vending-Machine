package beverage;

import org.junit.Test;
import services.BeverageType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElaichiTeaWrapperTest {
    @Test
    public void testGetElaichiTeaWrapperDescription() {
        Beverage beverage = new ElaichiTea();
        assertEquals("ELAICHI_TEA", beverage.getBeverageDescription());
    }

    @Test
    public void testGetElaichiTeaWrapperType() {
        Beverage beverage = new ElaichiTea();
        assertEquals(BeverageType.ELAICHI_TEA, beverage.getBeverageType());
    }

    @Test
    public void testSetElaichiTeaWrapperType() {
        Beverage beverage = new ElaichiTea();
        beverage.setBeverageType(BeverageType.HOT_WATER);
        assertEquals(BeverageType.HOT_WATER, beverage.getBeverageType());
    }


}
