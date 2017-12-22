package kr.devdogs.omok.ingame;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ScreenDesign extends JFrame{
	public GameBoardDesign gameBoardDesign;
	public TopDesign topDesign;
	public ChatView chatView;
	
	public ScreenDesign () {
		gameBoardDesign = new GameBoardDesign();
		topDesign = new TopDesign();
		chatView = new ChatView();
		
//		try{
//	    	  chatView.setting(Main.cSocket, Main.userId);
//	      }catch(Exception e){
//	    	  e.printStackTrace();
//		}
//	      
//	      
//	      ReceiveChatThread recThread = new ReceiveChatThread();
//			recThread.setSocket(Main.cSocket);
//			recThread.setChatView(chatView);
//			recThread.start();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/kr/devdogs/omok/images/thumbnail_img.png"));
		setTitle("Omok_Online");	//	�봽濡쒓렇�옩 ���씠��
		setResizable(false);	//	�궗�슜�옄 �궗�씠利� 蹂�寃� 遺덇�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	//	李� �궗�씠利� 吏��젙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//	寃뚯엫李� 醫낅즺�떆 �봽濡쒓렇�옩 醫낅즺
		setLocationRelativeTo(null);	//	�떎�뻾�떆 �솕硫� 以묒븰�뿉�꽌 �떎�뻾

		getContentPane().add(gameBoardDesign, BorderLayout.WEST);
		getContentPane().add(topDesign, BorderLayout.NORTH);
		getContentPane().add(chatView, BorderLayout.EAST);
		
		setVisible(true);	//	李� 媛��떆�꽦 true/false
	}
}