package weather;

import observer.concrets.DisplayedConditions;
import observer.concrets.DisplayedPredictions;
import sujet.concrets.WeatherData;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        Timer timer = new Timer();
        DisplayedConditions conditions = new DisplayedConditions(data);
        DisplayedPredictions predictions = new DisplayedPredictions(data);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                data.setMesures(generate(14, 26), generate(5, 100), generate(990, 1100));
            }
        };
        timer.schedule(task, 2000, 1000);
    }

    public static float generate(int low, int high){
        Random r = new Random();
        return (float)  r.nextInt(high-low) + low;
    }
}
