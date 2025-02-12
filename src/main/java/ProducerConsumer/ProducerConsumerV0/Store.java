package ProducerConsumer.ProducerConsumerV0;

import java.util.ArrayList;
import java.util.List;

//here, Store is acting as shared resource for Producer & Consumer
public class Store {

    //    we are going to have multiple items
    private List<Object> items = new ArrayList<>();
    private int MAX_SIZE = 5;

    public void add(Object item){
        System.out.println("Item is being produced :" + items.size());
        items.add(item);
    }

    public void substract(){
        System.out.println("Item is being consumed:" + items.size());
        items.remove(items.size()-1);
    }

    public List<Object> getItems() {
        return items;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
