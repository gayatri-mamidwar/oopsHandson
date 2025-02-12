package ProducerConsumer.ProducerConsumerSyncBlock;

//Consumer is producing continuously without returning anything Hence, use Runnable interface
public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            //wrapping outside gate i.e if stmt using synchronized block.
            // we are locking store so, only 1 can execute at a time. hence either producer or consumer will get into it.
            synchronized (store) {
                if (store.getItems().size() > 0) {
                    store.substract();
                }
            }
        }
    }
}
