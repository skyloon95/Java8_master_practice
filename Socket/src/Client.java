
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;




public class Client {
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	// 1. �����͸� ��� ���� ������

	// 2. �����͸� ��� ���� ������

	public void connect() {
		try {
			System.out.println("���� �õ�");
			clientSocket = new Socket("127.0.0.1", 10005);
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}



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

	public void streamSetting() {

		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

		} catch (Exception e) {

		}
	}



	public Client() {
		connect();
		streamSetting();
		dataSend();
		dataRecv(); 
	}

	public static void main(String[] args) {
		new Client();
	}

}


