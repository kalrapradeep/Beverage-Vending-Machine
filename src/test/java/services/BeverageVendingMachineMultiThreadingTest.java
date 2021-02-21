package services;

import ingredients.IngredientType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BeverageVendingMachineMultiThreadingTest {
    @Test
    public void testMultiThreadingBeverageMachine_shouldPrepareSome() throws InterruptedException {
        BeverageVendingMachine beverageVendingMachine = new BeverageVendingMachine(10);
        beverageVendingMachine.refill(IngredientType.HOT_MILK, 200);
        beverageVendingMachine.refill(IngredientType.HOT_WATER, 500);
        beverageVendingMachine.refill(IngredientType.SUGAR_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.TEA_LEAVES_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.GINGER_SYRUP, 100);
        beverageVendingMachine.refill(IngredientType.ELAICHI_SYRUP, 100);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Runnable> runnableArrayList = new ArrayList<>();
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(1, BeverageType.HOT_MILK);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(2, BeverageType.HOT_WATER);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(3, BeverageType.GINGER_TEA);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(4, BeverageType.COFFEE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(5, BeverageType.ELAICHI_TEA);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(6, BeverageType.COFFEE);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(7, BeverageType.ELAICHI_TEA);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(8, BeverageType.ELAICHI_TEA);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(9, BeverageType.HOT_MILK);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(10, BeverageType.HOT_WATER);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        runnableArrayList.add(
                () -> {
                    try {
                        beverageVendingMachine.prepareBeverage(3, BeverageType.HOT_WATER);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        );
        for (int i = 0; i < runnableArrayList.size(); i++) {
            executorService.execute(runnableArrayList.get(i));
        }
        Thread.sleep(1500);
        beverageVendingMachine.getLowIngredients();
        beverageVendingMachine.refill(IngredientType.HOT_MILK, 200);
        beverageVendingMachine.refill(IngredientType.COFFEE_SYRUP, 200);
        try {
            beverageVendingMachine.prepareBeverage(1, BeverageType.COFFEE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(1500);
        beverageVendingMachine.getLowIngredients();

    }
}
