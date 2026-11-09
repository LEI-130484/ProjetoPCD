package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class SensorEvent extends Event {

    private long waitTime;

    public SensorEvent(Areas area, Type type, int id, long time) {
        super(area, type, id);
        this.waitTime = time;
    }

    public long getTime() {
        return this.waitTime;
    }

    @Override
    Areas getArea() {
        return area;
    }

    @Override
    Type getType() {
        return type;
    }

    @Override
    int getId() {
        return id;
    }
    
}
