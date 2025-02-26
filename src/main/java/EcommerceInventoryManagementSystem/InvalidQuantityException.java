package EcommerceInventoryManagementSystem;

//InvalidQuantityException as Checked exception, So extends Exception also need to throws in method signature
public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
