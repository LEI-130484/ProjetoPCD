package iscot.client;

import java.io.IOException;

import iscot.events.Event;

public abstract class Sensor extends Client{

    public void sendEvent(Event event) throws IOException, ClassNotFoundException {
        getOutClient().writeObject(event);
        String s = (String) getInClient().readObject();
        System.out.println(s);
    }

}
