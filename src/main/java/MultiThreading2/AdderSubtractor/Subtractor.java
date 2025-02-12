package MultiThreading2.AdderSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value;
    private Lock lock;

    public Subtractor(Value value, Lock lock){
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(long i=1; i<=100000; i++){
//            System.out.println("Subtracting " + i);
            //apply lock before entering into critical session
            lock.lock();
            value.setX(value.getX() - i);           //here if u subtract 1 & in adder add 1 instead of i, at the end i!=0.We want it 0 so subtract i
            lock.unlock();
        }
        return null;
    }
}
