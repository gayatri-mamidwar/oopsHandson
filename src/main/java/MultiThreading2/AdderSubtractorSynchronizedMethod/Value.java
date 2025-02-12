package MultiThreading2.AdderSubtractorSynchronizedMethod;

public class Value {
    private long x = 0;

    public long getX() {
        return x;
    }
//
//    public void setX(long x) {
//        this.x = x;
//    }

    //in synchronized method the shared resource(here Value cls) itself provides method
    synchronized void incrementBy(long v){
        x += v;
    }

    synchronized void decrementBy(long v){
        x -= v;
    }
}
