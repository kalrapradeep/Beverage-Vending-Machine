package ingredients;

import beverage.Beverage;

public abstract class Milk extends Ingredient {
    /**
     * @param ingredientType  to define the type of ingredient
     * @param quantity        to define the quantity of a particular ingredient needed
     * @param wrappedBeverage to wrap a beverage by milk
     * @throws IllegalArgumentException while calling Ingredient class constructor when quantity or wrappedBeverage is invalid
     */

    protected Milk(IngredientType ingredientType, int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(ingredientType, quantity, wrappedBeverage);
    }
}
