package ProducerConsumer.ProducerConsumerSemaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

//here, Store is acting as shared resource for Producer & Consumer
public class Store {

    /*
    we are going to have multiple items
    List is not thread safe and therefore when
    multiple threads are making changes, we are getting inconsistency
    private List<Object> items = new ArrayList<>();
     */

    private ConcurrentLinkedQueue<Object> items = new ConcurrentLinkedQueue<>();
    private int MAX_SIZE = 5;

    public void add(Object item){
        System.out.println("Item is being produced :" + items.size());
        items.add(item);                    //add() -> ConcurrentLinkedQueue method
    }

    public void substract(){
        System.out.println("Item is being consumed:" + items.size());
        items.remove();                     //remove() -> ConcurrentLinkedQueue method
    }

    public ConcurrentLinkedQueue<Object> getItems() {
        return items;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}

// Concurrent Data Structures : Behind the scenes these will be properly doing things
// CAS : Compare the swap
// Locks : Concurrent Hashmap : take locks on buckets