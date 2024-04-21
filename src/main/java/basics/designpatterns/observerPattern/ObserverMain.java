package basics.designpatterns.observerPattern;

public class ObserverMain {
    public static void main(String[] args) throws InterruptedException {
        YoutubeChannel myChannel = new YoutubeChannel("HAi");

        Observer john = new YoutubeSubscriber("John");
        Observer bob = new YoutubeSubscriber("Bob");
        Observer tom = new YoutubeSubscriber("Tom");

        myChannel.addSub(john);
        myChannel.addSub(bob);
        myChannel.addSub(tom);

        myChannel.nofifyAll(new YoutubeEvent(Event_Type.NEW_VIDEO, "Design patterns"));
        myChannel.removeSub(tom);
        System.out.println();
        Thread.sleep(5000);
        myChannel.nofifyAll(new YoutubeEvent(Event_Type.LIVE, "JAVA for beginners"));

    }
}