package iscot.events.HighLevelOrderEvents;

import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvent;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {
    private boolean startIrrigation;

    public AreaIrrigationOrderEvent(Areas area, int id, boolean startIrrigation) {
        super(area, id);
        this.startIrrigation = startIrrigation;
    }

    public boolean isStartIrrigation() {
        return startIrrigation;
    }

    @Override
    public String toString() {
        return "AreaIrrigationOrderEvent [Area=" + getArea() + ", Regar=" + startIrrigation + "]";
    }
}