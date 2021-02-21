package ingredients;

import beverage.Coffee;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SugarSyrupTest {
    @Test
    public void createSugarSyrupNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new SugarSyrup(1, null);
        });

    }

    @Test
    public void createSugarSyrupNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new SugarSyrup(-1, new Coffee());
        });

    }

    @Test
    public void createSugarSyrupWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new SugarSyrup(1, new Coffee());
        assertEquals(ingredient.getIngredientType(), IngredientType.SUGAR_SYRUP);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof Coffee);
    }

}