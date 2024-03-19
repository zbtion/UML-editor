package Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

import java.awt.BorderLayout;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setTitle("UML editor");

        JPanel canvas = Canvas.get_instance();
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        JToolBar toolbar = new Toolbar();
        frame.getContentPane().add(toolbar, BorderLayout.WEST);

        JMenuBar menubar = new Menubar();
        frame.getContentPane().add(menubar, BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
