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
                System.out.println("novo ciclo");
                Socket socket = ss.accept();
                System.out.println("entrou um cliente");

                Connection connection = new Connection(in, out, socket);
                Thread thread = new Thread(connection);
                thread.start();
            }
        } finally {
            ss.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Server server = new Server();
        server.startServing();
    }

}
