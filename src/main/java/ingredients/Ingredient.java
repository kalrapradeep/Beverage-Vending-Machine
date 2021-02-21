package ingredients;

import beverage.Beverage;

public abstract class Ingredient extends Beverage {

    private int quantity;
    private Beverage wrappedBeverage;
    private IngredientType ingredientType;

    /**
     * @param ingredientType  to set the type what type of ingredient it is. example coffeesyrup etc.
     *                        Using ingredient type as enum instead of string to make the code more readable
     * @param quantity        to set the quantity of ingredient used
     * @param wrappedBeverage to wrap the beverage with the ingredient
     * @throws IllegalArgumentException in case when wrapped beverage or quantity is invalid
     */
    protected Ingredient(IngredientType ingredientType, int quantity, Beverage wrappedBeverage) throws IllegalArgumentException {
        super(null);
        if (wrappedBeverage == null || quantity < 0)
            throw new IllegalArgumentException();
        setBeverageType(wrappedBeverage.getBeverageType());
        this.ingredientType = ingredientType;
        this.wrappedBeverage = wrappedBeverage;
        this.quantity = quantity;
    }

    /**
     * @return ingredientType which is actually the the type of ingredient
     */
    public IngredientType getIngredientType() {

        return ingredientType;
    }

    /**
     * @return quantity the quantity of ingredient used
     */
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * @return wrappedBeverage which is the beverage wrapped on which this ingredient is mixed
     */
    public Beverage getWrappedBeverage() {

        return wrappedBeverage;
    }
}
