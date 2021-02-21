package ingredients;

import beverage.Coffee;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeSyrupTest {
    @Test
    public void createCoffeeSyrupNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new CoffeeSyrup(1, null);
        });


    }

    @Test
    public void createCoffeeSyrupNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new CoffeeSyrup(-1, new Coffee());
        });

    }

    @Test
    public void createCoffeeSyrupWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new CoffeeSyrup(1, new Coffee());
        assertEquals(ingredient.getIngredientType(), IngredientType.COFFEE_SYRUP);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof Coffee);
    }

}