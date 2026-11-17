package iscot.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import iscot.events.Event;
import iscot.server.Server;

public abstract class Client {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket; 

    public void sendEvent(Event event) throws IOException, ClassNotFoundException {
        out.writeObject(event);
        String s = (String) in.readObject();
        System.out.println(s);
    }

    public void connectToServer() throws IOException {
        InetAddress server = InetAddress.getByName("127.0.0.1");
        this.socket = new Socket(server, Server.PORTO);

        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }
}
