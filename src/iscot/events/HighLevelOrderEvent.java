package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class HighLevelOrderEvent extends Event {

    public HighLevelOrderEvent(Areas area, Type type, int id) {
        super(area, type, id);
    }

    Areas getArea() {
        return this.area;
    }

    Type getType() {
        return this.type;
    }

    int getId() {
        return this.id;
    }
    
}
