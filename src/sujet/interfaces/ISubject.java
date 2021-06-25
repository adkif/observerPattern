package sujet.interfaces;

import observer.interfaces.IObserver;

public interface ISubject {
    void create(IObserver obs);
    void delete(IObserver obs);
    void notifyObservers();
}
