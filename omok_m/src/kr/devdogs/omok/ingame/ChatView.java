package kr.devdogs.omok.ingame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ChatView extends JPanel{
	JFrame frame;
	JLabel topLine;     // 상단부
	  JTextArea showArea;   // 대화창
	  JPanel bottomLine;    // 하단부
	  JTextField inputBox;    // 입력창
	  JButton sendButton;   // '보내기'버튼
	  
	  BufferedReader br;
	  PrintWriter pw;
	  Socket chatSocket;
	   
	  String userId;
	  String sendString;

   public ChatView(){
      //   패널 사이즈 설정
      setPreferredSize(new Dimension(Main.CHAT_WIDTH,Main.CHAT_HEIGHT));
      
      design();	
      
   }
   
   public void setting(Socket cSocket, String userId) throws Exception{
	   this.chatSocket = cSocket;
      this.userId = userId;
//      try{
//    	  this.br = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
//    	  this.pw = new PrintWriter(chatSocket.getOutputStream(), true);
//      }catch(Exception e){
//    	  e.printStackTrace();
//      }
      this.br = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
	  this.pw = new PrintWriter(chatSocket.getOutputStream(), true);

      sendMessage("IDjavaproject1234"+userId);
   }

   public void design() {
	   		this.setLayout(new BorderLayout());
		  
		  // 상단부
		  topLine = new JLabel("채팅창");
		  this.add(topLine, BorderLayout.PAGE_START);
		 
		  // 대화창
		  showArea = new JTextArea("");
		  showArea.setLineWrap(true);     // 자동 줄바꿈
		  this.add(new JScrollPane(showArea), BorderLayout.CENTER); // scroll-bar 붙임
		 
		  // 하단부
		  bottomLine = new JPanel();
		  inputBox = new JTextField(15);
		  sendButton = new JButton("보내기");
		  bottomLine.add(inputBox);
		  bottomLine.add(sendButton);
		  this.add(bottomLine, BorderLayout.PAGE_END);
		  
		  ActionListener actionListener = new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	String msg = inputBox.getText();
					  if(!msg.equals("")) {
						  System.out.println("action: "+msg);
						  sendMessage(msg);
						  inputBox.setText("");
					  }
			    }
			};
		  
		// Action
		  inputBox.addActionListener(actionListener);     // JTextField의 Enter키 이벤트 발생
		  sendButton.addActionListener(actionListener);
		 
	  }
   
   public void sendMessage(String msg) {
	   		System.out.println("send: "+msg);
		  pw.println(msg);
		  pw.flush();
	  }
   
   public void receiveMessage(String msg) {
	   System.out.println("receive"+msg);
		  showArea.append(msg+"\n");
		  showArea.setCaretPosition(showArea.getText().length());
	  }
   /*
   private void receiveMyMessage(JTextArea tp, String msg, Color c)
   {
	   c=Color.BLUE;
       StyleContext sc = StyleContext.getDefaultStyleContext();
       AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

       aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
       aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

       int len = tp.getDocument().getLength();
       tp.setCaretPosition(len);
       tp.setCharacterAttributes(aset, false);
       tp.replaceSelection(msg);
   }
   */

}
