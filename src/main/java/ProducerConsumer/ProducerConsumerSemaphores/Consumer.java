package ProducerConsumer.ProducerConsumerSemaphores;

import java.util.concurrent.Semaphore;

//Consumer is producing continuously without returning anything Hence, use Runnable interface
public class Consumer implements Runnable {

    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            // now Semaphore will take care of count. no need to write 'if' statement externally
           // if (store.getItems().size() > 0) {

            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.substract();

            producerSemaphore.release();
        }
    }
}

// consumer count --;
// consume
// producer count ++;