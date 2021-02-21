package ingredients;

import beverage.Beverage;

public class HotMilkIngredient extends Milk {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by Hot Milk
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public HotMilkIngredient(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.HOT_MILK, quantity, wrappedBeverage);
    }
}
