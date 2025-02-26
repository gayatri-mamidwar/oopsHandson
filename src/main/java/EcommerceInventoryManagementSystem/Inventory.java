package EcommerceInventoryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;          //initializing here ,also fine

    public Inventory() {
        items = new HashMap<>();
    }

    public void add(T item) throws InvalidQuantityException {
        if(item.getQuantity() <= 0){

            //InvalidQuantityException is Checked (extending from Exception) So,need to use with method signature
            throw new InvalidQuantityException("Quantity must be greater than 0");
        }

        else if(items.containsKey(item.getId())){
            throw new DuplicateItemException("Item with the same ID is already present in the inventory");
        }
        items.put(item.getId(), item);
    }

    public void remove(String id){
        items.remove(id);
    }

    public void remove(T item){
        items.remove(item.getId());
    }

    public T retrieve(String itemId){
        if(!items.containsKey(itemId)){
            throw new ItemNotFoundException("Item ID '" + itemId + "' does not exist in the inventory.");
        }
        return items.get(itemId);
    }

    public List<T> getAllItems(){
        return new ArrayList<>(items.values());         //extract all values put it into list & return list
    }

}

