package ingredients;

import beverage.Beverage;

public class CoffeeSyrup extends Syrup {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by coffee syrup
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public CoffeeSyrup(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.COFFEE_SYRUP, quantity, wrappedBeverage);
    }
}
