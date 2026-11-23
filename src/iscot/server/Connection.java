package iscot.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import iscot.events.Event;

public class Connection implements Runnable{

    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    public Connection(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            serve();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void serve() throws IOException, ClassNotFoundException {
        int i = 0;
        while(true) {
            Event event = (Event) in.readObject();
            
            System.out.println("Menssagem do cliente:" + event);
            out.writeObject("Thx" + i++);
        }
    }
}
