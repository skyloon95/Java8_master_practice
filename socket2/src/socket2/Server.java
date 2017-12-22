package socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	public Server() {
		try {
			serverSocket = new ServerSocket(10005);
			System.out.println("서버 생성");
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트 연결");
		}
		catch(Exception e) {

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
