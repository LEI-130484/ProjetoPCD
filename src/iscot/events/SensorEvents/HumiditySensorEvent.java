package iscot.events.SensorEvents;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class HumiditySensorEvent extends SensorEvent {
    private double humidityPercentage;

    public HumiditySensorEvent(Areas area, int id, double humidityPercentage) {
        super(area, id);
        this.humidityPercentage = humidityPercentage;
    }

    public double getHumidityPercentage() {
        return humidityPercentage;
    }

    @Override
    public String toString() {
        return "HumiditySensorEvent [Area=" + getArea() + ", Humidade=" + humidityPercentage + "%]";
    }
}