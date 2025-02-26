package EcommerceInventoryManagementSystem;

import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems {

    private LinkedList<Item> recentlyViewedItems;
    private int MAX_SIZE = 3;

    public RecentlyViewedItems(){
        recentlyViewedItems = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item){
        recentlyViewedItems.remove(item);           //1st remove the item from LL, from where it is then add
        recentlyViewedItems.add(item);

        if(recentlyViewedItems.size() > MAX_SIZE){
            recentlyViewedItems.removeFirst();
        }
    }

    public List<Item> getRecentlyViewedItems(){
        return recentlyViewedItems;
    }
}
