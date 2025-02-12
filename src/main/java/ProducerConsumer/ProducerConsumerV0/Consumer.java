package ProducerConsumer.ProducerConsumerV0;

//Consumer is producing continuously without returning anything Hence, use Runnable interface
public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {

//            if items are available then consume
            if (store.getItems().size() > 0) {
                store.substract();
            }
        }
    }
}
