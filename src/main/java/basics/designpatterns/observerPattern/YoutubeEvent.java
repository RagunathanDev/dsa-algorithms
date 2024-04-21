package basics.designpatterns.observerPattern;

public class YoutubeEvent {
    private Event_Type event;
    private String topic;

    public YoutubeEvent(Event_Type event, String topic){
        this.event = event;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "YoutubeEvent{" +
                "event=" + event +
                ", topic='" + topic + '\'' +
                '}';
    }
}


