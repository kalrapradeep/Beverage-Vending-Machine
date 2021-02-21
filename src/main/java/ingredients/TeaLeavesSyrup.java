package ingredients;

import beverage.Beverage;

public class TeaLeavesSyrup extends Syrup {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by tea leaves syrup
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public TeaLeavesSyrup(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.TEA_LEAVES_SYRUP, quantity, wrappedBeverage);

    }
}
