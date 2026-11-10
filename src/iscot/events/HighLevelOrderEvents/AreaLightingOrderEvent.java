package iscot.events.HighLevelOrderEvents;

import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvent;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {
    private boolean turnOn;

    public AreaLightingOrderEvent(Areas area, int id, boolean turnOn) {
        super(area, id);
        this.turnOn = turnOn;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    @Override
    public String toString() {
        return "AreaLightingOrderEvent [Area=" + getArea() + ", Ligar=" + turnOn + "]";
    }
}