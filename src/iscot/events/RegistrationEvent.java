package iscot.events;

import iscot.Area;
import iscot.enums.Type;

public class RegistrationEvent extends Event{
    private Type typeOfClient;
    private Area area;

    public RegistrationEvent(Type type, Area area) {
        this.area = area;
        this.typeOfClient = type;
    }

    public Type getTypeOfClient() {
        return this.typeOfClient;
    }

    public Type getArea() {
        return this.area;
    }
}
