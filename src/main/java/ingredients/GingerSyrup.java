package ingredients;

import beverage.Beverage;

public class GingerSyrup extends Syrup {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by ginger syrup
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public GingerSyrup(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.GINGER_SYRUP, quantity, wrappedBeverage);

    }
}
