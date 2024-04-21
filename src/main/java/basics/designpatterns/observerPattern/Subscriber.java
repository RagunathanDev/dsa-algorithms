package basics.designpatterns.observerPattern;

public interface Subscriber {
    void addSub(Observer observer);
    void removeSub(Observer observer);
    void nofifyAll (YoutubeEvent event);
}
