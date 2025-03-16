package Generics;

//T,V are class level Generics
public class Pair<T, V> {
    T first;
    V second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    //This is method level Generic. We need to mention it before return type in <> brace.
    // So, <K> -> type of K, K -> return type
    public <K> K doSomething(K something){
        return something;
    }
}
