package EcommerceInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsAndExceptionsClient {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Electronics("E1", "Laptop", 999.99, 5, 24));
        items.add(new Clothing("C1", "T-Shirt", 19.99, 100, "M"));
        items.add(new Book("B1", "Java Programming", 59.99, 50, "John Doe"));

        /* Print all item IDs in the inventory using map.
                Use map and forEach to execute it */
        items.stream()
                .map((item) -> item.getId())
                .forEach((data) -> System.out.println(data));


        /* Create a list of item names in lowercase and print it.
        Hint : Use toLowerCase method of String along with map */
        List<String> itemNames = items.stream()
                .map((item) -> item.getName().toLowerCase())
                .toList();
        System.out.println("item names in lowercase : " + itemNames);


        /* Generate a list of the lengths of item names.
                Use length method of String along with map */
        List<Integer> itemLengths = items.stream()
                .map((item) -> item.getName().length())
                .toList();
        System.out.println("item Lengths : " + itemLengths);

        /*
        Task 2: Filtering and Matching
        Goal: Practice filtering and matching conditions with streams.
                Practice:
        1) Find all items priced above 1000 and print their details.
        2) Check if any item in the inventory has a quantity of 0 using anyMatch.
        3) Verify that all items have a price greater than 0 using allMatch.
        4) Confirm that no item has a negative quantity using noneMatch */

        // Find all items priced above 1000 and print their details.
        List<Item> itemsAboveGivenPrice = items.stream().filter((item) -> item.getPrice() > 1000).toList();
        System.out.println("itemsAboveGivenPrice = " + itemsAboveGivenPrice);

        // Check if any item in the inventory has a quantity of 0 using anyMatch.
        boolean itemsWithZeroQuantity = items.stream()
                .anyMatch((item) -> item.getQuantity() == 0);
        System.out.println("itemsWithZeroQuantity = " + itemsWithZeroQuantity);

        // Verify that all items have a price greater than 0 using allMatch.
        boolean isAllItemsPriceGreaterThanZero = items.stream()
                .allMatch((item) -> item.getPrice() > 0);
        System.out.println("isAllItemsPriceGreaterThanZero = " + isAllItemsPriceGreaterThanZero);

        // Confirm that no item has a negative quantity using noneMatch
        boolean noItemWithNegativeQuantity = items.stream()
                .noneMatch((item) -> item.getQuantity() < 0);
        System.out.println("noItemWithNegativeQuantity = " + noItemWithNegativeQuantity);

        /* Task 3 :
        Assume the inventory contains various items (e.g., electronics, clothing, books) with attributes like name, price, quantity.
        Write a program to achieve the following using a single stream pipeline:
        Filter items with a price greater than 1000 and a quantity greater than 0 (available stock).
        Extract only the names of these items.
        Remove duplicate names (if any).
        Sort the names in alphabetical order.
        Limit the result to the top 5 names.
        Collect the final list into a List<String> and print it.
         */
        List<String> filteredData = items.stream()
                .filter((item) -> item.getPrice() > 1000 && item.getQuantity() > 0)
                .map((item) -> item.getName())
                .distinct()
                .sorted()
                .limit(5)
                .toList();          //or use .collect(Collectors.toList());
        System.out.println("filteredData " + filteredData);

        /*
        Task 4: Reduce for Aggregation
        Practice:
        Calculate the total quantity of all items in the inventory.
        Find the most expensive item using reduce.
        Concatenate all item names into a single comma-separated string.
         */
        /* using for loop logic-
        int totalQuantity = 0;
        for(Item item : items){
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
         */

        //Calculate the total quantity of all items in the inventory
        int totalQuantity = items.stream().
                map((item) -> item.getQuantity())
                .reduce(0, (total, quantity) -> {
                    total = total + quantity;
                    return total;
                });
        System.out.println("totalQuantity = " + totalQuantity);

        //Find the most expensive item using reduce.
        double expensiveItem = items.stream()
                .map(item -> item.getPrice())
                .reduce(Double.MIN_VALUE, (ans, price) ->
                        Math.max(ans, price));
        System.out.println("expensive item = " + expensiveItem);

        //Concatenate all item names into a single comma-separated string.
        Optional<String> result = items.stream()
                .map((item) -> item.getName())
                .reduce((ans, curr) -> ans + "," + curr);

        System.out.println("All items names into a single comma-separated string = " + result.get());

        /* OR- Without using reduce
                 .map(Item::getName)
                .collect(Collectors.joining(","));
                 */

        Map<String, Integer> itemMap = items.stream()
                .collect(Collectors.toMap(
                        item -> item.getName(),
                        item -> item.getQuantity()
                ));
        System.out.println("Map of itemName & itemQuantity = " + itemMap);


    }

}
