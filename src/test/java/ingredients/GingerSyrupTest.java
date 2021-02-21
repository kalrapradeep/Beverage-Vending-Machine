package ingredients;

import beverage.Coffee;
import beverage.ElaichiTea;
import beverage.GingerTea;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GingerSyrupTest {
    @Test
    public void createGingerSyrupNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new GingerSyrup(1, null);
        });

    }

    @Test
    public void createGingerSyrupNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new GingerSyrup(-1, new GingerTea());
        });

    }

    @Test
    public void createGingerSyrupWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new GingerSyrup(1, new GingerTea());
        assertEquals(ingredient.getIngredientType(), IngredientType.GINGER_SYRUP);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof GingerTea);
    }

}