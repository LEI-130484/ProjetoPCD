package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event{

    public RegistrationEvent(Type type, Areas area, int id) {
        super(area, type, id);
    }
    
    public Type getType() {
        return this.type;
    }

    public Areas getArea() {
        return this.area;
    }
}
