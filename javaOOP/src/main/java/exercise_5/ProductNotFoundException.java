package exercise_5;

// Custom exception for handling cases where product ID is not found
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
