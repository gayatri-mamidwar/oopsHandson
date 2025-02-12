package ProducerConsumer.ProducerConsumerSyncMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Store store = new Store();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=1; i<=10; i++){
            executorService.submit(new Producer(store));
        }

        for(int i=1; i<=10; i++) {
            executorService.submit(new Consumer(store));
        }
    }
}
