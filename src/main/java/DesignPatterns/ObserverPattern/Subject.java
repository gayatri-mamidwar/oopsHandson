package DesignPatterns.ObserverPattern;

//who will notify changes, add observer & remove observer
public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
