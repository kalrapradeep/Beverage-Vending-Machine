package services;

import exceptions.InsufficientIngredientException;
import exceptions.SystemNotIdleException;
import ingredients.IngredientType;

import java.util.ArrayList;

public class BeverageVendingMachine {
    private ArrayList<BeverageOutlet> beverageOutlets;

    /**
     * @param numberOfOutlets to initialize the machine with fixed outlets
     * @throws IllegalArgumentException in case when the number of outlets input are non positive
     */
    public BeverageVendingMachine(int numberOfOutlets) throws IllegalArgumentException {
        if (numberOfOutlets <= 0)
            throw new IllegalArgumentException("Number of outlets passed is less than 0");
        IngredientContainer.nullifyIngredientBasket();
        beverageOutlets = new ArrayList<>(numberOfOutlets);
        for (int i = 0; i < numberOfOutlets; i++) {
            beverageOutlets.add(new BeverageOutlet(BeverageOutletState.IDLE, i + 1));
        }
    }

    /**
     * @param outletNumber on which the beverage is to be dispatched
     * @param beverageType type of beverage which is to be dispatched
     * @throws IllegalArgumentException        in case when outlet number is not in range or when prepareBeverage throws Illegal argument for bad beverage type argument
     * @throws InsufficientIngredientException in case when quantity to prepare a particular beverage type is not available as thrown by prepare beverage class
     * @throws SystemNotIdleException          in case when the outletNumber outlet is not IDLE as thrown by prepare beverage function
     */
    public void prepareBeverage(int outletNumber, BeverageType beverageType) throws IllegalArgumentException, InsufficientIngredientException, SystemNotIdleException {
        if (outletNumber <= 0 || outletNumber > beverageOutlets.size()) {
            throw new IllegalArgumentException("Outlet number is to be in the range");
        }
        beverageOutlets.get(outletNumber - 1).prepareBeverage(beverageType);
    }

    /**
     * @param ingredientType ingredient to be refilled in the machine
     * @param quantity       of ingredient to be refilled
     * @throws IllegalArgumentException in case when quantity is less than 0 or type is null
     */
    public void refill(IngredientType ingredientType, int quantity) throws IllegalArgumentException {
        IngredientContainer.refillIngredient(ingredientType, quantity);
    }

    /**
     * @return the number of outlets in the machine
     */
    public int getNumberOfOutlets() {
        return beverageOutlets.size();
    }

    /**
     * To display all the ingredients which are currently running low
     */
    public void getLowIngredients() {
        Indicator.displayLowIngredients();
    }
}
