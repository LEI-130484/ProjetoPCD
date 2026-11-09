package iscot.events;

public class SensorEvent extends Event {

    private long time;

    public SensorEvent(long time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }
    
}
