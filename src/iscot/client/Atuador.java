package iscot.client;

import java.io.IOException;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.HighLevelOrderEvent;

public abstract class Atuador extends Client{

    public Atuador(Areas area) {
        super(Type.ACTUATOR, area);
    }

    public HighLevelOrderEvent getEventFromServer() throws ClassNotFoundException, IOException {
        HighLevelOrderEvent event = (HighLevelOrderEvent) getInClient().readObject();

        return event;
    }
}
