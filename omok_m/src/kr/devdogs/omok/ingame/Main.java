/**
 *
 */
package kr.devdogs.omok.ingame;

import java.net.Socket;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @author snow
 *
 */
public class Main {
	//	李� �겕湲�
	public static final int SCREEN_WIDTH=1280;
	public static final int SCREEN_HEIGHT=960;

	//	寃뚯엫蹂대뱶 �겕湲�
	public static final int GAMEBOARD_WIDTH = 800;
	public static final int GAMEBOARD_HEIGHT = 800;

	//	�긽�떒諛� �겕湲�
	public static final int TOPBAR_WIDTH = SCREEN_WIDTH;
	public static final int TOPBAR_HEIGHT = SCREEN_HEIGHT - GAMEBOARD_HEIGHT-20;
	public static final int START_BUTTON_WIDTH = 1145-20;
	public static final int START_BUTTON_HEIGHT = 0;
	
	// 채팅창 크기
		 public static final int CHAT_WIDTH = SCREEN_WIDTH-GAMEBOARD_WIDTH-10;
		 public static final int CHAT_HEIGHT = SCREEN_HEIGHT-TOPBAR_HEIGHT;


	//	諛붾몣臾대뒳
	public static final float BOARDLINE_START_WIDTH = GAMEBOARD_WIDTH/8f;
	public static final float BOARDLINE_WIDTH = GAMEBOARD_WIDTH - BOARDLINE_START_WIDTH*2f;
	public static final float BOARDLINE_START_HEIGHT = GAMEBOARD_HEIGHT/8f;
	public static final float BOARDLINE_HEIGHT = GAMEBOARD_HEIGHT - BOARDLINE_START_HEIGHT*2f;
	public static final int LINE = 19;
	public static final float LINE_SPACE = BOARDLINE_WIDTH/(LINE-1);
	public static final int CROSS_POINT = (LINE*LINE);
	public static final int BOARDLINE_END_WIDTH = (int)(BOARDLINE_START_WIDTH + LINE*LINE_SPACE);
	public static final int BOARDLINE_END_HEIGHT = (int)(BOARDLINE_START_HEIGHT + LINE*LINE_SPACE);

	//	諛붾몣�룎 �겕湲�(諛섏�由�)
	public static final float STONE_SIZE = LINE_SPACE-3f;

	public static JFrame screen;
	
	public static Socket cSocket;
	public static String userId;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		cSocket = new Socket("127.0.0.1", 8888);
//	    userId = ;
		
		Client.getInstance().connect();
		screen = new ScreenDesign();
		//�겢�씪�씠�뼵�듃 留뚮뱾硫� 諛⑸쭔�뱾�뼱�빞�븿! 洹몃윭�땲源� �씠嫄� 蹂대궡�빞�븿
		
		//�겢�씪�씠�뼵�듃 踰덊샇, 肄붾뱶踰덊샇, �쉶�썝 踰덊샇, 諛� 踰덊샇, x異�, y異�
		String data = "100" + "/" + Client.getInstance().getMyId() + "/" + "0" + "/" + "0" + "/" + "0";

		Client.getInstance().dataSend(data);
	}

}
