package services;

import exceptions.InsufficientIngredientException;
import ingredients.HotMilkIngredient;
import ingredients.Ingredient;
import ingredients.IngredientType;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BeverageVendingMachineTest {

    @Test
    public void createBeverageVendingMachineWithNonPositiveOutlets_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(0);
        });

    }

    @Test
    public void refillBeverageVendingMachineWithInvalidIngredient_shouldThrowError() {
        BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
        assertThrows(IllegalArgumentException.class, () -> {
            beverageVendingMachine.refill(null, 1);
        });
    }

    @Test
    public void refillBeverageVendingMachineWithNegativeQuantity_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
            beverageVendingMachine.refill(IngredientType.COFFEE_SYRUP, -1);
        });
    }

    @Test
    public void prepareBeverage_beverageVendingMachineWithInvalidOutletNumber_shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
            beverageVendingMachine.prepareBeverage(0, BeverageType.COFFEE);
        });
    }

    @Test
    public void checkGetNumberOfOutlets() {
        BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
        assertEquals(beverageVendingMachine.getNumberOfOutlets(), 10);
    }

    @Test
    public void prepareBeverage_Coffee_ElaichiTea_GingerTea_HotMilk_HotWater_shouldPrepareSome() {
        BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
        beverageVendingMachine.refill(IngredientType.HOT_MILK, 50);
        beverageVendingMachine.refill(IngredientType.HOT_WATER, 500);
        beverageVendingMachine.refill(IngredientType.SUGAR_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.TEA_LEAVES_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.GINGER_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.ELAICHI_SYRUP, 100);
        try {
            beverageVendingMachine.prepareBeverage(1, BeverageType.COFFEE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            beverageVendingMachine.prepareBeverage(2, BeverageType.ELAICHI_TEA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            beverageVendingMachine.prepareBeverage(3, BeverageType.HOT_MILK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            beverageVendingMachine.prepareBeverage(4, BeverageType.GINGER_TEA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            beverageVendingMachine.prepareBeverage(5, BeverageType.HOT_WATER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}