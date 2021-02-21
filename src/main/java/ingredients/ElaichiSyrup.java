package ingredients;

import beverage.Beverage;

public class ElaichiSyrup extends Syrup {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by elaichi syrup
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public ElaichiSyrup(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.ELAICHI_SYRUP, quantity, wrappedBeverage);

    }
}
