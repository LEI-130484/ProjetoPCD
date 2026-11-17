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
        
        try {
            Socket socket = ss.accept();
            try {
                doConnections(socket);
                serve();
            } finally {
                socket.close();
            }
        } finally {
            ss.close();
        }
    }

    private void serve() throws IOException, ClassNotFoundException {
        //while(true) {
            Event event = (Event) in.readObject();

//            if(Event.equals("FIM")) {
//                break;
//            }
            
            System.out.println("Menssagem do cliente:" + event);
            out.writeObject("Thx");
        //}
    }

    private void doConnections(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public static void main(String[] args) {
        try {
            new Server().startServing();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
