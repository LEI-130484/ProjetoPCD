package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;
import java.io.Serializable;

public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    Areas area;
    Type type;
    int id;
    long timestamp;

    public Event(Areas area, Type type, int id) {
        this.area = area;
        this.type = type;
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }

    public Areas getArea() {
        return area;
    }
    public Type getType() {
        return type;
    }
    public int getId() {
        return id;
    }
    public long getTimestamp() {
        return timestamp;
    }
}