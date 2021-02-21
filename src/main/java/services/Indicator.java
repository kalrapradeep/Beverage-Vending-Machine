package services;

import ingredients.IngredientType;

import java.util.Set;

public class Indicator {
    /**
     * To display low running ingredients. It calls the function getLowRunningIngredients from
     * the IngredientContainer class.
     */
    public static void displayLowIngredients() {
        Set<IngredientType> lowIngredientsSet = IngredientContainer.getLowRunningIngredients();
        if (lowIngredientsSet.size() == 0) {
            System.out.println("No Ingredients are currently running low");
        } else {
            System.out.println("Below are the ingredients running low");
            for (IngredientType ingredientType : lowIngredientsSet) {
                System.out.println("Ingredient " + ingredientType + " is running low");
            }
        }
    }
}
