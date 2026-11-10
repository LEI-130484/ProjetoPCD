package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event {
    private static final long serialVersionUID = 1L;

    public RegistrationEvent(Type type, Areas area, int id) {
        super(area, type, id);
    }

    @Override
    public String toString() {
        return "RegistrationEvent [Tipo=" + getType() + ", Area=" + getArea() + ", ID=" + getId() + "]";
    }
}