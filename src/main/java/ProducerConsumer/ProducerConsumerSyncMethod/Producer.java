package ProducerConsumer.ProducerConsumerSyncMethod;

//Producer is producing continuously without returning anything Hence, use Runnable interface
public class Producer implements Runnable {

    private Store store;

    public Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            /*
            Here, issue is we are just synchronized add() i.e. only internal part we wrapped but 'if' stmt is also
            critical section. Hence, still getting o/p as > max items. So, need to wrap outside gate also.here if stmt
             */
            if(store.getMAX_SIZE() > store.getItems().size())       //this is critical section
                store.add(new Object());    //this is also critical section, hence used synchronized for add() of Store
        }
    }
}
