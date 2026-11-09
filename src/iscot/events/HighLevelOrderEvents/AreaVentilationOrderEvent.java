package iscot.events.HighLevelOrderEvents;

import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvent;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {
    private boolean startVentilation;

    public AreaVentilationOrderEvent(Areas area, int id, boolean startVentilation) {
        super(area, id);
        this.startVentilation = startVentilation;
    }

    public boolean isStartVentilation() {
        return startVentilation;
    }

    @Override
    public String toString() {
        return "AreaVentilationOrderEvent [Area=" + getArea() + ", Ventilação=" + startVentilation + "]";
    }
}