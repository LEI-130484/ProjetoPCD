package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class HighLevelOrderEvent extends Event {

    public HighLevelOrderEvent(Areas area, Type type, int id) {
        super(area, type, id);
    }

    @Override
    Areas getArea() {
        return this.area;
    }

    @Override
    Type getType() {
        return this.type;
    }

    @Override
    int getId() {
        return this.id;
    }
    
}
