package observer.concrets;

import observer.interfaces.IDisplayed;
import observer.interfaces.IObserver;

public class DisplayedTiers implements IObserver, IDisplayed {
    @Override
    public void display() {

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

    }
}
