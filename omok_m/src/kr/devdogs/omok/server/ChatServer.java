package kr.devdogs.omok.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	public static ArrayList<PrintWriter> myOutputList;	//서버로 접속한 client의 output을 모아둔  ArrayList
	
	public static void main(String[] args) {
		myOutputList = new ArrayList<PrintWriter>();
		
		try {
			ServerSocket sSocket = new ServerSocket(8888);
			
			while(true) {
				Socket cSocket = sSocket.accept();	//서버 소켓에서 client가 감지되면 client socket을 생성
				ClientManagerThread cThread = new ClientManagerThread();	//client마다 ClientManagerThread를 가짐
				cThread.setSocket(cSocket);
				
				myOutputList.add(new PrintWriter(cSocket.getOutputStream()));	//client의 outputstream을 printwriter로 변형하여 add
				
				cThread.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
