package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Event {

    Areas area;
    Type type;
    int id;

    public Event(Areas area, Type type, int id) {
        this.area = area;
        this.type = type;
        this.id = id;
    }

    abstract Areas getArea();
    abstract Type getType();
    abstract int getId();
}
