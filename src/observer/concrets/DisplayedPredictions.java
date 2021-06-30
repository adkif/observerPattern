package observer.concrets;

import observer.interfaces.IDisplayed;
import observer.interfaces.IObserver;
import sujet.interfaces.ISubject;

import java.util.ArrayList;

public class DisplayedPredictions implements IObserver, IDisplayed {
    private float temperature;
    private float humidity;
    private float pressure;
    private ISubject weatherData;
    private ArrayList<Float> pressures;

    public DisplayedPredictions(ISubject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.create(this);
        this.pressures = new ArrayList();
    }

    public String predict(float previousPressure){
        String state = "";
        if(this.pressure - previousPressure > 0 ){
            state = "Amélioration en cours";
        }else if(this.pressure - previousPressure < 0){
            state = "le temps se rafraîchit";
        }else{
            state = "Dépression bien installée";
        }
        return state;
    }

    @Override
    public void display() {
        int size = pressures.size();
       if(size > 1){
           System.out.println("Predictions: "+this.predict(pressures.get(size-2)));
       }
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.pressures.add(pressure);
        this.display();
    }
}
