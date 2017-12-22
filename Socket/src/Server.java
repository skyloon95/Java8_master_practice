import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;




public class Server {
	private ServerSocket serverSocket;
	private Map<String, Socket> clientSocket = new HashMap<>();

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;




	// 1. �����͸� ��� ���� ������

	// 2. �����͸� ��� ���� ������



	public void serverSetting() {

		try {

			// localhost, 10002
			serverSocket = new ServerSocket(10005); // ���ε�
			System.out.println("���� ����");
			
			int i = 0;
			
			while(i<3) {
				i++;
				clientSocket.put(String.format("%s", i),serverSocket.accept());
				// ������ ���� �Ϸ� �� �κ�z
				System.out.println("Ŭ���̾�Ʈ ���� ����");
			}

		} catch (Exception e) {

		} 

	}

	public void closeAll(){

		try {
			serverSocket.close();
			for(String x : clientSocket.keySet()) {
				clientSocket.get(x).close();
			}
			dataInputStream.close();
			dataOutputStream.close();
		} catch (Exception e) {

		}

	}

	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {

		}
	}



/*
	public void dataRecv() {
		new Thread(new Runnable() {
			boolean isThread = true;
			
			@Override

			public void run() {

				while(isThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if(recvData.equals("/quit"))
							isThread = false;
						else 
							System.out.println("���� : "+recvData);

					} catch (Exception e) {

					}
				} 
			}

		}).start();
	}




	public void dataSend() {

		new Thread(new Runnable() {
			Scanner in = new Scanner(System.in);
			boolean isThread = true;

			@Override
			public void run() {
				while(isThread){

					try {
						String sendData = in.nextLine();
						if(sendData.equals("/quit"))
							isThread = false;
						else 
							dataOutputStream.writeUTF(sendData);

					} catch (Exception e) {

					} 
				}      
			}
		}).start();

	}

*/
	public Server() {
		serverSetting();
		streamSetting();
		/*
		dataRecv();
		dataSend();
		*/
	}

	public static void main(String[] args) {
		new Server();
	}

}
