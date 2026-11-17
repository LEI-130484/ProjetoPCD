package iscot.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import iscot.enums.Areas;
import iscot.events.Event;
import iscot.events.SensorEvents.HumiditySensorEvent;
import iscot.server.Server;

public class Client {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket; 

    public void runClient () throws ClassNotFoundException {
        try {
            connectToServer();
            sendEvent(new HumiditySensorEvent(Areas.BedRoom, 1, 50));
        } catch ( IOException e ) {
        } finally {
            try {
                socket.close ();
            } catch ( IOException e ) {

            }
        }
    }

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

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.runClient();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
