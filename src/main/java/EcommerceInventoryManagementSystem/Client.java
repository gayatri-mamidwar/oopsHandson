package EcommerceInventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Electronics("E1", "Laptop " , 999.99,5,  24));
        items.add(new Clothing("C1", "T-Shirt" ,19.99, 100, "M"));
        items.add(new Book("B1", "Java Programming", 59.99,50, "John Doe"));

        for(Item item : items){
            System.out.println("Before sort : " + item.getName());
        }

        Collections.sort(items);
        for(Item item : items){
            System.out.println("After sort : " + item.getName());
        }
    }
}
