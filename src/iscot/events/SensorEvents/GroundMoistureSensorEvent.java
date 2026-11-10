package iscot.events.SensorEvents;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class GroundMoistureSensorEvent extends SensorEvent {
    private boolean isDry;

    public GroundMoistureSensorEvent(Areas area, int id, boolean isDry) {
        super(area, id);
        this.isDry = isDry;
    }

    public boolean isDry() {
        return isDry;
    }

    @Override
    public String toString() {
        return "GroundMoistureSensorEvent [Area=" + getArea() + ", Terreno Seco=" + isDry + "]";
    }
}