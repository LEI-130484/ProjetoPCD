package iscot.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import iscot.events.Event;

public class Connection implements Runnable{

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket;
    
    public Connection(ObjectInputStream in, ObjectOutputStream out, Socket socket) {
        this.in = in;
        this.out = out;
        this.socket = socket;
    }

    public void run() {
        try {
            doConnections(socket);
            registerClient();
            serve();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void registerClient() throws ClassNotFoundException, IOException {
        Event event = (Event) in.readObject();
        System.out.println(event);
    }

    private void doConnections(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    private void serve() throws IOException, ClassNotFoundException {
        while(true) {
            Event event = (Event) in.readObject();
            
            System.out.println("Menssagem do cliente:" + event);
            out.writeObject("Thx");
        }
    }
}
