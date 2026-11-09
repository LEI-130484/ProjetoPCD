package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class SensorEvent extends Event {

    public SensorEvent(Areas area, int id) {
        super(area, Type.SENSOR, id);
    }
}