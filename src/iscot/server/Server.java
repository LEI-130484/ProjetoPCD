package iscot.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import iscot.events.Event;

public class Server {
    public final static int PORTO = 8080;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public void startServing() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(PORTO);

        try{
            while(true) {
                Socket socket = ss.accept();
                doConnections(socket);
                registerClient();

                Connection connection = new Connection(in, out);
                Thread thread = new Thread(connection);
                thread.start();
            }
        } finally {
            ss.close();
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


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Server server = new Server();
        server.startServing();
    }

}
