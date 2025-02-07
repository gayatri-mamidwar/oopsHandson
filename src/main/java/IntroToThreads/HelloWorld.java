package IntroToThreads;

public class HelloWorld implements Runnable {
    public void print(){
        System.out.println("Hello World from.." + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        print();
    }
}
