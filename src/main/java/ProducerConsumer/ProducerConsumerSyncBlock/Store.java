package ProducerConsumer.ProducerConsumerSyncBlock;

import java.util.ArrayList;
import java.util.List;

//here, Store is acting as shared resource for Producer & Consumer
public class Store {
    private List<Object> items = new ArrayList<>();
    private int MAX_SIZE = 5;

    public synchronized void add(Object item){          //add "synchronized" for both methods
        System.out.println("Item is being produced :" + items.size());
        items.add(item);
    }

    public synchronized void substract(){
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
