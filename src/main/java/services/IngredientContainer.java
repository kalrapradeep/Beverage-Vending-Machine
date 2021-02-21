package services;

import beverage.Beverage;
import constants.SufficientIngredientConstants;
import exceptions.InsufficientIngredientException;
import ingredients.Ingredient;
import ingredients.IngredientType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IngredientContainer {
    private static Map<IngredientType, Integer> ingredientQuatityMap = new HashMap<>();

    /**
     * @param beverage object which is to be produced from the ingredients available. This method
     * @throws InsufficientIngredientException in case where any of 1 ingredient is either
     *                                         not available or is not sufficient. Commits the change after no exception thrown.
     * @throws IllegalArgumentException        in case when the parameter beverage is null
     * @implNote All the methods of this class are modelled synchronous so that we can edit the container
     * one at a time to tackle the critical section area while producing multiple beverages. It recursively
     * checks each layer of ingredient in wrapped beverage and commits the changes in quantity of ingredients
     * if and only if all the ingredients are available for that particular beverage.
     */
    public static synchronized void commitBeverageIngredients(Beverage beverage) throws InsufficientIngredientException, IllegalArgumentException {
        if (beverage == null)
            throw new IllegalArgumentException("Beverage is null");
        if (!(beverage instanceof Ingredient))
            return;
        IngredientType ingredientType = ((Ingredient) beverage).getIngredientType();
        if (!ingredientQuatityMap.containsKey(ingredientType)) {
            throw new InsufficientIngredientException(beverage.getBeverageDescription() + " cannot be prepared because " + ((Ingredient) beverage).getIngredientType() + " is not available");
        }
        if (ingredientQuatityMap.get(ingredientType) < ((Ingredient) beverage).getQuantity()) {
            throw new InsufficientIngredientException(beverage.getBeverageDescription() + " cannot be prepared because " + ((Ingredient) beverage).getIngredientType() + " is not sufficient");
        }
        commitBeverageIngredients(((Ingredient) beverage).getWrappedBeverage());
        ingredientQuatityMap.put(ingredientType, ingredientQuatityMap.get(ingredientType) - ((Ingredient) beverage).getQuantity());
    }

    /**
     * @return the set of ingredient types which are currently running low
     * @implNote It checks all the minimum quantities of ingredients as mentioned in constants package
     * and adds the ingredient to a set if its quantity falls below certain level as specified.
     */
    public static synchronized Set<IngredientType> getLowRunningIngredients() {
        Set<IngredientType> lowRunningIngredientSet = new HashSet<>();
        if (SufficientIngredientConstants.ELAICHI_SYRUP_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.ELAICHI_SYRUP, 0)) {
            lowRunningIngredientSet.add(IngredientType.ELAICHI_SYRUP);
        }
        if (SufficientIngredientConstants.HOT_MILK_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.HOT_MILK, 0)) {
            lowRunningIngredientSet.add(IngredientType.HOT_MILK);
        }
        if (SufficientIngredientConstants.HOT_MILK_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.HOT_WATER, 0)) {
            lowRunningIngredientSet.add(IngredientType.HOT_WATER);
        }
        if (SufficientIngredientConstants.COFFEE_SYRUP_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.COFFEE_SYRUP, 0)) {
            lowRunningIngredientSet.add(IngredientType.COFFEE_SYRUP);
        }
        if (SufficientIngredientConstants.SUGAR_SYRUP_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.SUGAR_SYRUP, 0)) {
            lowRunningIngredientSet.add(IngredientType.SUGAR_SYRUP);
        }
        if (SufficientIngredientConstants.GINGER_SYRUP_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.GINGER_SYRUP, 0)) {
            lowRunningIngredientSet.add(IngredientType.GINGER_SYRUP);
        }
        if (SufficientIngredientConstants.TEA_LEAVES_SYRUP_QUANTITY > ingredientQuatityMap.getOrDefault(IngredientType.TEA_LEAVES_SYRUP, 0)) {
            lowRunningIngredientSet.add(IngredientType.TEA_LEAVES_SYRUP);
        }

        return lowRunningIngredientSet;
    }

    /**
     * @param ingredientType which is to be refilled
     * @param quantity       of ingredient type to be refilled
     * @throws IllegalArgumentException in case when quantity is less than 0 or ingredient type is null provided by user to refill
     */
    public static synchronized void refillIngredient(IngredientType ingredientType, int quantity) throws IllegalArgumentException {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity of refill cannot be less than 0");
        if (ingredientType == null)
            throw new IllegalArgumentException("Invalid ingredient type provided");
        System.out.println("Refilling " + ingredientType.toString() + " with quantity " + quantity);
        ingredientQuatityMap.put(ingredientType, ingredientQuatityMap.getOrDefault(ingredientType, 0) + quantity);
    }

    /**
     * To make sure there is nothing in the ingredient container while running the machine for first time
     */
    public static synchronized void nullifyIngredientBasket() {
        ingredientQuatityMap.clear();
    }
}
