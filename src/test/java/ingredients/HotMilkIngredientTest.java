package ingredients;

import beverage.Coffee;
import beverage.ElaichiTea;
import beverage.GingerTea;
import beverage.HotMilk;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotMilkIngredientTest {
    @Test
    public void createHotMilkIngredientNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new HotMilkIngredient(1, null);
        });


    }

    @Test
    public void createHotMilkIngredientWithNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new HotMilkIngredient(-1, new HotMilk());
        });

    }

    @Test
    public void createHotMilkIngredientWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new HotMilkIngredient(1, new HotMilk());
        assertEquals(ingredient.getIngredientType(), IngredientType.HOT_MILK);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof HotMilk);
    }

}