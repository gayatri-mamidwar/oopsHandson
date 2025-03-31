package DesignPatterns.ObserverPattern;

//CurrStatisticsDisplay is observer.
public class CurrStatisticsDisplay implements Display, Observer {

    private float temp;
    private float humidity;
    private float pressure;
    private Subject subject;

    public CurrStatisticsDisplay(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Current Statistics : ");
        System.out.println("Temp : " + temp + " " + "humidity : " + humidity + " " + "pressure : "+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
