package iscot.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int PORTO = 8080;
    private BufferedReader in;
    private PrintWriter out;

    public void startServing() throws IOException {
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

    private void serve() throws IOException {
        while(true) {
            String message = in.readLine();

            if(message.equals("FIM")) {
                break;
            }
            
            System.out.println("Menssagem do cliente:" + message);
            out.println(message);
        }
    }

    private void doConnections(Socket socket) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream ())), true);
    }

    public static void main(String[] args) {
        try {
            new Server().startServing();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
