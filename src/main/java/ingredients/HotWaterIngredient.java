package ingredients;

import beverage.Beverage;

public class HotWaterIngredient extends Water {
    /**
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by Hot Water
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    public HotWaterIngredient(int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(IngredientType.HOT_WATER, quantity, wrappedBeverage);

    }
}
