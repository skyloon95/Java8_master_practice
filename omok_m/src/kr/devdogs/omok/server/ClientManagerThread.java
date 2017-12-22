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
				text = tmpbuf.readLine(); //mySocket에서 데이터를 읽어옴
				
				//소켓이 종료됐을 경우
				if(text == null) {
					System.out.println(myId+"이(가) 나갔습니다.");	//서버에 알림
					
					//모든 client에게 알림
					for(int i = 0; i<ChatServer.myOutputList.size(); i++) {
						ChatServer.myOutputList.get(i).println(myId+"이(가) 나갔습니다.");
						ChatServer.myOutputList.get(i).flush();
					}
					break;
				}
				
				String[] split = text.split("javaproject1234");
				
				//client가 사용할 ID를 입력한 경우
				if(split.length == 2 && split[0].equals("ID")) {
					myId = split[1];
					System.out.println(myId+"이(가) 입장하였습니다.");	//서버에 알림
					
					//모든 client에게 알림
					for(int i=0; i<ChatServer.myOutputList.size();i++) {
						ChatServer.myOutputList.get(i).println(myId+"이(가) 입장하였습니다.");
						ChatServer.myOutputList.get(i).flush();
					}
					continue;
				}
				
				//모든 client에게 메세지 전달
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

