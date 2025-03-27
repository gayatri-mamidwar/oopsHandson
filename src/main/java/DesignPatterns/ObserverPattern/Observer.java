package DesignPatterns.ObserverPattern;

//who will observe which chnges are done
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
