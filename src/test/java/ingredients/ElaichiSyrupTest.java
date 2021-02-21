package ingredients;

import beverage.Coffee;
import beverage.ElaichiTea;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElaichiSyrupTest {
    @Test
    public void createElaichiSyrupNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new ElaichiSyrup(1, null);
        });

    }

    @Test
    public void createElaichiSyrupNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new ElaichiSyrup(-1, new ElaichiTea());
        });

    }

    @Test
    public void createElaichiSyrupWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new ElaichiSyrup(1, new ElaichiTea());
        assertEquals(ingredient.getIngredientType(), IngredientType.ELAICHI_SYRUP);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof ElaichiTea);
    }

}