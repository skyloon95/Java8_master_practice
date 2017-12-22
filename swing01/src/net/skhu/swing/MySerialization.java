package net.skhu.swing;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MySerialization {

    public static void save(Component parentWnd, Object object) {
        JFileChooser dialog = new JFileChooser();
        int result = dialog.showSaveDialog(parentWnd);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String path = dialog.getSelectedFile().getAbsolutePath();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
                out.writeObject(object);
                out.close();
             } catch(Exception i) {
                 JOptionPane.showMessageDialog(parentWnd, i.getMessage());
             }
        }
    }

    public static Object open(Component parentWnd) {
        JFileChooser dialog = new JFileChooser();
        int result = dialog.showOpenDialog(parentWnd);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String path = dialog.getSelectedFile().getAbsolutePath();
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
                Object object = in.readObject();
                in.close();
                return object;
             } catch(Exception i) {
                 JOptionPane.showMessageDialog(parentWnd, i.getMessage());
             }
        }
        return null;
    }
}
