package kr.devdogs.omok.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManagerThread extends Thread {
	private Socket mySocket;
	private String myId;
	
	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			
			String text;
			
			while(true) {
				text = tmpbuf.readLine(); //mySocket���� �����͸� �о��
				
				//������ ������� ���
				if(text == null) {
					System.out.println(myId+"��(��) �������ϴ�.");	//������ �˸�
					
					//��� client���� �˸�
					for(int i = 0; i<ChatServer.myOutputList.size(); i++) {
						ChatServer.myOutputList.get(i).println(myId+"��(��) �������ϴ�.");
						ChatServer.myOutputList.get(i).flush();
					}
					break;
				}
				
				String[] split = text.split("javaproject1234");
				
				//client�� ����� ID�� �Է��� ���
				if(split.length == 2 && split[0].equals("ID")) {
					myId = split[1];
					System.out.println(myId+"��(��) �����Ͽ����ϴ�.");	//������ �˸�
					
					//��� client���� �˸�
					for(int i=0; i<ChatServer.myOutputList.size();i++) {
						ChatServer.myOutputList.get(i).println(myId+"��(��) �����Ͽ����ϴ�.");
						ChatServer.myOutputList.get(i).flush();
					}
					continue;
				}
				
				//��� client���� �޼��� ����
				System.out.println(myId+"> "+text);//server
				for(int i=0; i<ChatServer.myOutputList.size();i++) {
					ChatServer.myOutputList.get(i).println(myId+"> "+text);
					ChatServer.myOutputList.get(i).flush();
				}
			}
			
			ChatServer.myOutputList.remove(new PrintWriter(mySocket.getOutputStream()));
			mySocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket socket) {
		mySocket = socket;
	}
}

