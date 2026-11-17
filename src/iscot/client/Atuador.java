package iscot.client;

import java.io.IOException;

import iscot.events.HighLevelOrderEvent;

public abstract class Atuador extends Client{

    public HighLevelOrderEvent getEventFromServer() throws ClassNotFoundException, IOException {
        HighLevelOrderEvent event = (HighLevelOrderEvent) getInClient().readObject();

        return event;
    }
    
}
