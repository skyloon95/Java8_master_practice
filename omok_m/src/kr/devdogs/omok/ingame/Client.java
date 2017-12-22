package kr.devdogs.omok.ingame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


//싱글톤으로 만들어 
public class Client {
	//서버와 클라이언트는 1:다 이니 List로 만들 필요 X
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private int myId; //클라이언트의 고유번호임
	
	public int getMyId() {
		return myId;
	}

	public void setMyId(int myId) {
		this.myId = myId;
	}

	//싱글톤 어찌구
	public static Client getInstance() {
		return LazyHolder.INSTANCE;
	}

	//싱글톤 어쩌구
	private static class LazyHolder {
		private static final Client INSTANCE = new Client();
	}

	//

	public void connect() {
		//      try {
		//         System.out.println("접속 시도");
		//         clientSocket = new Socket("localhost", 12347);
		//         System.out.println("접속 완료");
		//         dataInputStream = new DataInputStream(clientSocket.getInputStream());
		//         dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		//         System.out.println("에베베베");
		//         myId = dataInputStream.readInt();
		//         System.out.println(myId);
		//      } catch (Exception e) {
		//         e.printStackTrace();
		//      }
	}

	public void dataRecv() {
		new Thread(new Runnable() {
			boolean isThread = true;
			@Override
			public void run() {
				while(isThread) {
					try {
						String recvData = dataInputStream.readUTF(); //받은 데이터 저장
						
						System.out.println("받은 코드 : "+recvData);

						//a[0] : 클라이언트 번호, a[1] : 코드, a[2] : 방번호, a[3] : 회원번호, a[4] : x축 위치, a[5] : y축 위치
						String[] datas = recvData.split("/"); //받은 데이터를 구분할거임
						switch(datas[1]) {
						//105 : 흑돌 배치
						case "105" :
							Stone.putStone(Integer.parseInt(datas[4]), Integer.parseInt(datas[5]), false);
							break;
							//106 : 백돌 배치
						case "106" :
							Stone.putStone(Integer.parseInt(datas[4]), Integer.parseInt(datas[5]), true);
							break;
							//115 : 게임 시작 승인
						case "115" :
							GameBoardMouseListener.setIsStarted(true);
							Stone.resetMatrix();
							break;
							//116 : 게임 시작 실패
						case "116" :

							break;
							//117 : 33 조건 실패
						case "117" :

							break;
							//118 : 직전에 바둑돌을 놓은 사람이 승리
						case "118" :

							break;
							//500 : 바둑돌을 둘 차례가 아님
						case "500" :

							break;
						}
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}

	public void dataSend(String sendData) {
		try {
			//전송 코드에 클라이언트 아이디 들어가야함! 그거 추가해야함
			//지금 코드 양식 -> 코드/방번호/회원번호/x축위치/y축위치
			//전송 코드에 클라이언트 아이디 들어가야함
			//변경 코드 양식 -> 클라이언트아이디/코드/방번호/회원번호/x축위치/y축위치
			sendData = this.myId + "/" +sendData;
			System.out.println("전송 코드 : "+sendData);
			dataOutputStream.writeUTF(sendData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Client() {

		try {
			System.out.println("접속 시도");
			clientSocket = new Socket("localhost", 12347);
			System.out.println("접속 완료");
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			myId = dataInputStream.readInt();
			System.out.println("myId : "+myId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connect();
		dataRecv();
	}
}