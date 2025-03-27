package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//WeatherData is subject
public class WeatherData implements Subject {

    private float humidity;
    private float pressure;
    private float temp;
    private List<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("New Observer Registered...");
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println("Observer removed...");
        observers.remove(o);
    }

    //Whenever a change happens call notifyObserver method
    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        //if u want to do some modifications before calling notifyObserver()
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

