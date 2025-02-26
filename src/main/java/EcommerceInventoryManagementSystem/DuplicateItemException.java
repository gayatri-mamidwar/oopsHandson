package EcommerceInventoryManagementSystem;

//DuplicateItemException as unchecked, So extends RuntimeException
public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(String message) {
        super(message);
    }
}
