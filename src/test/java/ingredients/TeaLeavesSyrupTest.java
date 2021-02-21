package ingredients;

import beverage.Coffee;
import beverage.ElaichiTea;
import beverage.GingerTea;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeaLeavesSyrupTest {
    @Test
    public void createTeaLeavesSyrupNoWrappedBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new TeaLeavesSyrup(1, null);
        });

    }

    @Test
    public void createTeaLeavesSyrupNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new TeaLeavesSyrup(-1, new GingerTea());
        });

    }

    @Test
    public void createTeaLeavesSyrupWithValidArguments_shouldThrowError() {
        Ingredient ingredient = new TeaLeavesSyrup(1, new GingerTea());
        assertEquals(ingredient.getIngredientType(), IngredientType.TEA_LEAVES_SYRUP);
        assertEquals(ingredient.getQuantity(), 1);
        assertTrue(ingredient.getWrappedBeverage() instanceof GingerTea);
    }

}