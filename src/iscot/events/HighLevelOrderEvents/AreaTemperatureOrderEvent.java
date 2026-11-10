package iscot.events.HighLevelOrderEvents;

import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvent;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private double targetTemperature;

    public AreaTemperatureOrderEvent(Areas area, int id, double targetTemperature) {
        super(area, id);
        this.targetTemperature = targetTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    @Override
    public String toString() {
        return "AreaTemperatureOrderEvent [Area=" + getArea() + ", TempAlvo=" + targetTemperature + "ºC]";
    }
}