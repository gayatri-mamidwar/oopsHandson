package ProducerConsumer.ProducerConsumerSemaphores;

import java.util.concurrent.Semaphore;

//Producer is producing continuously without returning anything Hence, use Runnable interface
public class Producer implements Runnable {

    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            //now Semaphore will take care of counts. no need to externally write 'if' condition
            //if(store.getMAX_SIZE() > store.getItems().size())

            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

//            produce the item
            store.add(new Object());

//            signal the consumer
            consumerSemaphore.release();
        }
    }
}

// producer count --;
// produce
// consumer count ++;