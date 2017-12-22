package net.skhu.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SecondWnd {

    private JFrame frame;
    private JTextField textField;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JButton btnRemove;
    private JButton btnEdit;
    private JButton btnSave;
    private JButton btnOpen;
    private JScrollPane scrollPane;
    private JList<String> list;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SecondWnd window = new SecondWnd();
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
    public SecondWnd() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("클릭");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String s = textField.getText();
                listModel.addElement(s);
                textField.setText("");
            }
        });
        panel.add(button);
        
        btnRemove = new JButton("\uC120\uD0DD\uB41C \uD56D\uBAA9 \uC0AD\uC81C");
        btnRemove.setEnabled(false);
        btnRemove.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
        		int dialogResult = JOptionPane.showConfirmDialog(
                        btnRemove, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION){
                    int index = list.getSelectedIndex();
                    listModel.remove(index);
                    btnRemove.setEnabled(false);
                    btnEdit.setEnabled(false);
                    textField.setText("");
                }

        	}
        });
        panel.add(btnRemove);
        frame.getRootPane().setDefaultButton(button);
        
        btnEdit = new JButton("\uC218\uC815");
        panel.add(btnEdit);
        
        btnSave = new JButton("\uC800\uC7A5");
        btnSave.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
        		MySerialization.save(frame, listModel);
        	}
        });
        panel.add(btnSave);
        
        btnOpen = new JButton("\uC5F4\uAE30");
        btnOpen.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		listModel = (DefaultListModel<String>)MySerialization.open(frame);
                if (listModel != null)
                    list.setModel(listModel);

        	}
        });
        panel.add(btnOpen);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        list = new JList<String>(listModel);
        scrollPane.setViewportView(list);
    }

}
