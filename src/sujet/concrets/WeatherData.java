package sujet.concrets;

import observer.interfaces.IObserver;
import sujet.interfaces.ISubject;

import java.util.ArrayList;

public class WeatherData implements ISubject {
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<IObserver> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void create(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void delete(IObserver obs) {
        int i=observers.indexOf(obs);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer: observers){
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void updateMesures(){
        notifyObservers();
    }

    public void setMesures(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.updateMesures();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
