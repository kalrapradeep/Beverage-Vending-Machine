package exceptions;

public class InsufficientIngredientException extends Exception {
    /**
     * @param message to be wrapped in exception for insufficient ingredients
     */
    public InsufficientIngredientException(String message) {
        super(message);
    }
}
