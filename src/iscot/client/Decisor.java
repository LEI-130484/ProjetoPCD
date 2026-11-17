package iscot.client;

import java.io.IOException;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public class Decisor extends Client{

    public Decisor( Areas area) {
        super(Type.DECIDER, area);
    }

    public void sendEvent(Event event) throws IOException, ClassNotFoundException {
        getOutClient().writeObject(event);
        String s = (String) getInClient().readObject();
        System.out.println(s);
    }

}
