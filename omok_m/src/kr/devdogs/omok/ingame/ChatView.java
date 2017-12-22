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
	JLabel topLine;     // ��ܺ�
	  JTextArea showArea;   // ��ȭâ
	  JPanel bottomLine;    // �ϴܺ�
	  JTextField inputBox;    // �Է�â
	  JButton sendButton;   // '������'��ư
	  
	  BufferedReader br;
	  PrintWriter pw;
	  Socket chatSocket;
	   
	  String userId;
	  String sendString;

   public ChatView(){
      //   �г� ������ ����
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
		  
		  // ��ܺ�
		  topLine = new JLabel("ä��â");
		  this.add(topLine, BorderLayout.PAGE_START);
		 
		  // ��ȭâ
		  showArea = new JTextArea("");
		  showArea.setLineWrap(true);     // �ڵ� �ٹٲ�
		  this.add(new JScrollPane(showArea), BorderLayout.CENTER); // scroll-bar ����
		 
		  // �ϴܺ�
		  bottomLine = new JPanel();
		  inputBox = new JTextField(15);
		  sendButton = new JButton("������");
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
		  inputBox.addActionListener(actionListener);     // JTextField�� EnterŰ �̺�Ʈ �߻�
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
