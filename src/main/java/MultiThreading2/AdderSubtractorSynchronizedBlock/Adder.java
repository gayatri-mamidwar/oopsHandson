package MultiThreading2.AdderSubtractorSynchronizedBlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    //u can't pass anything in call(). So, we want to have input as attribute of a class

    private Value value;

    public Adder(Value value){
        this.value = value;
    }

    @Override
    public Void call() throws Exception {           //void 'v' should be in capital
        for(long i=1; i<=100000; i++){

            synchronized (value) {                  //this is synchronized block. we also have synchronized method
                value.setX(value.getX() + i);
            }
        }

        return null;
    }
}
