package EcommerceInventoryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;          //initializing here ,also fine

    public Inventory() {
        items = new HashMap<>();
    }

    public void add(T item){
        if(item.getQuantity() <= 0){
            throw new InvalidQuantityException("Quantity must be greater than 0");
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
        return items.get(itemId);
    }

    public List<T> getAllItems(){
        return new ArrayList<>(items.values());         //extract all values put it into list & return list
    }

}

