package ingredients;

import beverage.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotWaterIngredientTest {
    @Test
    public void createHotWaterIngredientNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new HotWaterIngredient(1, null);
        });

    }

    @Test
    public void createHotWaterIngredientWithNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new HotWaterIngredient(-1, new HotWater());
        });

    }

    @Test
    public void createHotWaterIngredientWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new HotWaterIngredient(1, new HotWater());
        assertEquals(ingredient.getIngredientType(), IngredientType.HOT_WATER);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof HotWater);
    }

}