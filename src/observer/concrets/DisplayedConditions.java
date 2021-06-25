package observer.concrets;

import observer.interfaces.IDisplayed;
import observer.interfaces.IObserver;
import sujet.interfaces.ISubject;

public class DisplayedConditions implements IObserver, IDisplayed {
    private float temperature;
    private float humidity;
    private float pressure;
    private ISubject weatherData;

    public DisplayedConditions(ISubject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.create(this);
    }

    @Override
    public void display() {
        System.out.println("Temperature (degre): "+this.temperature+" Humidity (%): "+this.humidity+" Pressure (bar): "+this.pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }
}
