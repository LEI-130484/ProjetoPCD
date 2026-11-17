package iscot.client;

import java.io.IOException;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class Sensor extends Client{

    public Sensor(Areas area) {
        super(Type.SENSOR, area);
        //TODO Auto-generated constructor stub
    }

    public void sendEvent(Event event) throws IOException, ClassNotFoundException {
        getOutClient().writeObject(event);
        String s = (String) getInClient().readObject();
        System.out.println(s);
    }

}
