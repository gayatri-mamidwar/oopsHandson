package MultiThreading2.AdderSubtractorSynchronizedBlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value;

    public Subtractor(Value value){
        this.value = value;
    }

    @Override
    public Void call() throws Exception {
        for(long i=1; i<=100000; i++){
//            System.out.println("Subtracting " + i);

            //pass shared data/attri in synchronized(). no need to externally use lock() & unlock()
            synchronized (value) {
                value.setX(value.getX() - i);           //here if u subtract 1 & in adder add 1 instead of i, at the end i!=0.We want it 0 so subtract i
            }
        }
        return null;
    }
}
