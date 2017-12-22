package kr.devdogs.omok.ingame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveChatThread extends Thread {
	private Socket chatSocket;
	private ChatView ccd;
	
	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
			
			String receiveString;
			String[] split;
			
			while(true) {
				receiveString = br.readLine();
				/*
				split = receiveString.split(">");
				
				//�۽��� client�� �ڽ��� ��� console�� ǥ������ ����
				if(split.length>=2 && split[0].equals(Main.userId)) {
					continue;
				}
				*/
				ccd.receiveMessage(receiveString);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket socket) {
		chatSocket = socket;
	}
	
	public void setChatView(ChatView ccd) {
		this.ccd = ccd;
	}
	
}
