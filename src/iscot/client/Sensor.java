package iscot.client;

import java.io.IOException;

import iscot.events.SensorEvent;

public abstract class Sensor extends Client{

    public abstract SensorEvent newEvent(); 

    public void clientLoop() throws ClassNotFoundException, IOException {
        //Obter o novo valor do sensor e construir mensagem
        SensorEvent event = newEvent();

        //Enviar mensagem ao servidor
        sendEvent(event);
    }

}
