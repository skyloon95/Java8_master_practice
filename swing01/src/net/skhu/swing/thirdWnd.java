package net.skhu.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class thirdWnd {

	JFrame frame;
	private JTextField textField1;
	private JList<String> list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					thirdWnd window = new thirdWnd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public thirdWnd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		textField1 = new JTextField();
		panel.add(textField1);
		textField1.setColumns(10);

		JButton btnButton1 = new JButton("\uCD94\uAC00");
		btnButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = textField1.getText();
				listModel.addElement(s);
				textField1.setText("");
			}
		});
		panel.add(btnButton1);

		list = new JList<String>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex();

				if(index<listModel.getSize()&&index>=0) {
					listModel.remove(index);
				}

			}
		});

		frame.getContentPane().add(list, BorderLayout.CENTER);
	}

}
