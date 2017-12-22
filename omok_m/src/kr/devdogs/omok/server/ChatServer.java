package kr.devdogs.omok.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	public static ArrayList<PrintWriter> myOutputList;	//������ ������ client�� output�� ��Ƶ�  ArrayList
	
	public static void main(String[] args) {
		myOutputList = new ArrayList<PrintWriter>();
		
		try {
			ServerSocket sSocket = new ServerSocket(8888);
			
			while(true) {
				Socket cSocket = sSocket.accept();	//���� ���Ͽ��� client�� �����Ǹ� client socket�� ����
				ClientManagerThread cThread = new ClientManagerThread();	//client���� ClientManagerThread�� ����
				cThread.setSocket(cSocket);
				
				myOutputList.add(new PrintWriter(cSocket.getOutputStream()));	//client�� outputstream�� printwriter�� �����Ͽ� add
				
				cThread.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
