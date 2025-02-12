package ProducerConsumer.ProducerConsumerSyncBlock;

//Producer is producing continuously without returning anything Hence, use Runnable interface
public class Producer implements Runnable {

    private Store store;

    public Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            //wrapping outside gate i.e 'if' using sync block

            synchronized (store) {
                if (store.getMAX_SIZE() > store.getItems().size())       //this is critical section
                    store.add(new Object());    //this is also critical section, hence used synchronized for add() of Store
                }
            }
    }
}
