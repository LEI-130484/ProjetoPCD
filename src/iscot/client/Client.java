package iscot.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.server.Server;

public abstract class Client {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket; 

    private Type type;
    private Areas area;

    public Client(Type type, Areas area) {
        this.type = type;
        this.area = area;
    }

    public ObjectInputStream getInClient() {
        return in;
    }

    public ObjectOutputStream getOutClient() {
        return out;
    }

	public Areas getArea() {
		return this.area;
	}

	public Type getType() {
		return this.type;
	}

    public void registerWithServer() {

    }

    public void connectToServer() throws IOException {
        InetAddress server = InetAddress.getByName("127.0.0.1");
        this.socket = new Socket(server, Server.PORTO);

        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }
}
