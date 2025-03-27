package DesignPatterns.ObserverPattern;

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrStatisticsDisplay currStatisticsDisplay = new CurrStatisticsDisplay(weatherData);

        weatherData.setMeasurements(30.2f, 20.5f, 15.3f);
        weatherData.setMeasurements(20.5f, 12.7f, 25.4f);

        //After removing observer nothing will print
        weatherData.removeObserver(currStatisticsDisplay);
        weatherData.setMeasurements(12.2f, 15.3f, 17.8f);       //this line wont print anything bcz we removed observer
    }
}
