package iscot.events.SensorEvents;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class LightSensorEvent extends SensorEvent {
    private double luz;

    public LightSensorEvent(Areas area, int id, double luz) {
        super(area, id);
        this.luz = luz;
    }

    public double getLuz() {
        return luz;
    }

    @Override
    public String toString() {
        return "LightSensorEvent [Area=" + getArea() + ", Luz=" + luz + "]";
    }
}