package MultiThreading2.AdderSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    //u can't pass anything in call(). So, we want to have input as attribute of a class

    private Value value;
    private Lock lock;

    public Adder(Value value, Lock lock){
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {           //void 'v' should be in capital
        for(long i=1; i<=100000; i++){
//            System.out.println("Adding " + i);
            lock.lock();                //lock() -> no other thread can access shared resource, avoid other thread to go into critical session
            value.setX(value.getX() + i);
            lock.unlock();          //after completing task unlock, so other threads will get lock
        }

        return null;
    }
}
