package services;

import beverage.*;
import constants.*;
import exceptions.InsufficientIngredientException;
import ingredients.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProductionService {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Map<BeverageType, Beverage> beverageTypeBeverageHashMap = new HashMap<>();

    /**
     * @param beverageType which is to be produced.
     * @return the beverage object produced by the service
     * @throws InsufficientIngredientException in case where the quantity of ingredients are insufficient
     *                                         or are unavailable.
     * @throws IllegalArgumentException        in case when wrapped beverage passed or quantity is invalid
     * @implNote It checks if the type of beverage object is already in the map
     * which is like a flyweight pattern. If it is not present then make a wrapped object containing
     * the beverage and check if the quantity of ingredients to make that object is sufficient by calling
     * IngredientContainer class. This method is not defined as synchronous so we can produce multiple at same time
     */
    public static Beverage produceBeverage(BeverageType beverageType) throws InsufficientIngredientException, IllegalArgumentException {
        Beverage wrappedBeverage;
        if (!beverageTypeBeverageHashMap.containsKey(beverageType)) {
            switch (beverageType) {
                case GINGER_TEA:
                    wrappedBeverage = new GingerTea();
                    wrappedBeverage = new HotWaterIngredient(GingerTeaConstants.HOT_WATER_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new HotMilkIngredient(GingerTeaConstants.HOT_MILK_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new TeaLeavesSyrup(GingerTeaConstants.TEA_LEAVES_SYRUP_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new GingerSyrup(GingerTeaConstants.GINGER_SYRUP_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new SugarSyrup(GingerTeaConstants.SUGAR_SYRUP_QUANTITY, wrappedBeverage);
                    break;
                case ELAICHI_TEA:
                    wrappedBeverage = new ElaichiTea();
                    wrappedBeverage = new HotWaterIngredient(ElaichiTeaConstants.HOT_WATER_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new HotMilkIngredient(ElaichiTeaConstants.HOT_MILK_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new TeaLeavesSyrup(ElaichiTeaConstants.TEA_LEAVES_SYRUP_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new ElaichiSyrup(ElaichiTeaConstants.ELAICHI_SYRUP_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new SugarSyrup(ElaichiTeaConstants.SUGAR_SYRUP_QUANTITY, wrappedBeverage);
                    break;
                case COFFEE:
                    wrappedBeverage = new Coffee();
                    wrappedBeverage = new HotWaterIngredient(CoffeeConstants.HOT_WATER_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new HotMilkIngredient(CoffeeConstants.HOT_MILK_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new CoffeeSyrup(CoffeeConstants.COFFEE_SYRUP_QUANTITY, wrappedBeverage);
                    wrappedBeverage = new SugarSyrup(CoffeeConstants.SUGAR_SYRUP_QUANTITY, wrappedBeverage);
                    break;
                case HOT_MILK:
                    wrappedBeverage = new HotMilk();
                    wrappedBeverage = new HotMilkIngredient(HotMilkConstants.HOT_MILK_QUANTITY, wrappedBeverage);
                    break;
                case HOT_WATER:
                    wrappedBeverage = new HotWater();
                    wrappedBeverage = new HotWaterIngredient(HotWaterConstants.HOT_WATER_QUANTITY, wrappedBeverage);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid beverage.Beverage Entered");
            }
            readWriteLock.writeLock().lock();
            try {
                beverageTypeBeverageHashMap.put(beverageType, wrappedBeverage);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
        readWriteLock.readLock().lock();
        try {
            wrappedBeverage = beverageTypeBeverageHashMap.get(beverageType);
        } finally {
            readWriteLock.readLock().unlock();
        }
        IngredientContainer.commitBeverageIngredients(wrappedBeverage);
        return wrappedBeverage;
    }
}
