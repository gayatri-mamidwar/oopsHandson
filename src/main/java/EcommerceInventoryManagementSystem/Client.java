package EcommerceInventoryManagementSystem;

import java.util.*;

import static java.util.Arrays.stream;

public class Client {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Electronics("E1", "Laptop", 999.99, 5, 24));
        items.add(new Clothing("C1", "T-Shirt", 19.99, 100, "M"));
        items.add(new Book("B1", "Java Programming", 59.99, 50, "John Doe"));

        for (Item item : items) {
            System.out.println("Before sort : " + item.getName());
        }

        // There is no default ordering for custom classes
        // Is it possible to give default ordering : Yes ! How ? Comparable
        // items.get(0).compareTo(items.get(1));
        Collections.sort(items);

        for (Item item : items) {
            System.out.println("After sort : " + item.getName());
        }

        /* Inventory : Multiple Items
          General Inventory
          Clothing Inventory
          Book Inventory
         */

//        Inventory<Animal>             ---> ASK TOMORROW IN CLASS. Why for Animal its showing from Abstractclasses folder?

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        electronicsInventory.add(new Electronics("E1", "Laptop", 999.99, 5, 24));
        electronicsInventory.add(new Electronics("E2", "Laptop", 999.99, 5, 24));
        electronicsInventory.add(new Electronics("E3", "Mobile", 99.99, 5, 24));

        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Clothing> clothingInventory = new Inventory<>();
        Inventory<Item> itemInventory = new Inventory<>();

        Item item1 = new Electronics("E1", "Laptop", 999.99, 5, 24);
        Item item2 = new Electronics("E2", "Mobile", 999.99, 5, 24);
        Item item3 = new Electronics("E3", "Watch", 999.99, 5, 24);
        Item item4 = new Electronics("E4", "Ipad", 999.99, 5, 24);
        Item item5 = new Electronics("E5", "Speaker", 999.99, 5, 24);

        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();
        recentlyViewedItems.addRecentlyViewedItem(item1);
        recentlyViewedItems.addRecentlyViewedItem(item3);
        recentlyViewedItems.addRecentlyViewedItem(item5);
        recentlyViewedItems.addRecentlyViewedItem(item2);

        recentlyViewedItems.addRecentlyViewedItem(item5);       //item5 will be removed & added at the first

        List<Item> recentlyViewedItemsList = recentlyViewedItems.getRecentlyViewedItems();
        System.out.println("-------Recently viewed Items :------- ");
        for (Item item : recentlyViewedItemsList) {
            System.out.println(item.getName());
        }


    }
}
