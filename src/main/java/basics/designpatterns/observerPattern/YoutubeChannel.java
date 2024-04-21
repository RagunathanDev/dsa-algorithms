package basics.designpatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements  Subscriber{
    private String name;
    private List<Observer> subscribers = new ArrayList<>();

    public YoutubeChannel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addSub(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeSub(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void nofifyAll(YoutubeEvent event) {
        for(Observer observer: subscribers) {
            observer.notifyMe(getName(), event);
        }
    }
}
