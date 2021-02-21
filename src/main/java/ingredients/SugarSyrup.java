package ingredients;

import beverage.Beverage;

public class SugarSyrup extends Syrup {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by sugar syrup
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public SugarSyrup(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.SUGAR_SYRUP, quantity, wrappedBeverage);
    }
}
