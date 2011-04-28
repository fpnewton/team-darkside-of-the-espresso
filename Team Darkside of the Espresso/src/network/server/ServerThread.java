package network.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import network.MessageKey;
import users.User;
import database.SqlDatabase;

public class ServerThread implements Runnable {
	private Socket connection;
	private SqlDatabase database;

	public ServerThread(Socket socket, SqlDatabase db) {
		database = db;
		connection = socket;
	}

	public void run() {
		while (true) {
			try {
				ObjectInputStream stream = new ObjectInputStream(
						connection.getInputStream());
				Message input = (Message) stream.readObject();

				processMessage(input);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void processMessage(Message msg) {
		switch (msg.getKey()) {
		case DB_GETALLUSERS:
			User users[] = database.getAllUsers();
			ArrayList<User> userList = new ArrayList<User>();
			
			for (User u : users)
			{
				userList.add(u);
			}
			
			sendMessage(new Message(MessageKey.DB_GETALLUSERS, "", userList));
			break;
		}
	}

	private void sendMessage(Message msg) {
		ObjectOutputStream ostream = null;

		try {
			ostream = new ObjectOutputStream(connection.getOutputStream());

			ostream.writeObject(msg);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (ostream != null) {
					ostream.flush();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}
