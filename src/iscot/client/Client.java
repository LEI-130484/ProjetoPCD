package iscot.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import iscot.server.Server;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket; 

    public void runClient () {
        try {
            connectToServer();
            sendMessages();
        } catch ( IOException e ) {
        } finally {
            try {
                socket.close ();
            } catch ( IOException e ) {

            }
        }
    }

    public void sendMessages() throws IOException {
        for (int i = 0; i < 5; i ++) {
            out.println("Ola " + i);
            String str = in.readLine();
            System.out.println(str);
        }
        out.println("FIM");
    }

    public void connectToServer() throws IOException {
        InetAddress server = InetAddress.getByName("127.0.0.1");
        this.socket = new Socket(server, Server.PORTO);

        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream ())), true);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.runClient();
    }
}
