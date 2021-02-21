package services;

import exceptions.InsufficientIngredientException;
import ingredients.CoffeeSyrup;
import ingredients.Ingredient;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BeverageOutletTest {
    @Test
    public void createBeverageOutletWithNullState_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageOutlet beverageOutlet = new BeverageOutlet(null, 1);
        });
    }

    @Test
    public void createBeverageOutletWithNonPositiveOutletNumber_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageOutlet beverageOutlet = new BeverageOutlet(BeverageOutletState.IDLE, 0);
        });
    }

    @Test
    public void setBeverageOutletWithNullState_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageOutlet beverageOutlet = new BeverageOutlet(BeverageOutletState.IDLE, 1);
            beverageOutlet.setBeverageOutletState(null);
        });
    }

    @Test
    public void prepareBeverageWithInvalidType_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageOutlet beverageOutlet = new BeverageOutlet(BeverageOutletState.IDLE, 1);
            beverageOutlet.prepareBeverage(null);
        });
    }

    @Test
    public void dispatchInvalidBeverage_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageOutlet beverageOutlet = new BeverageOutlet(BeverageOutletState.IDLE, 1);
            beverageOutlet.dispatchBeverage(null);
        });
    }


}