package iscot.events.SensorEvents;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class TemperatureSensorEvent extends SensorEvent {
    private double temperature;

    public TemperatureSensorEvent(Areas area, int id, double temperature) {
        super(area, id);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "TemperatureSensorEvent [Area=" + getArea() + ", Temp=" + temperature + "ºC]";
    }
}