package lab6.cw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Program extends JFrame {
    public static void main(String argv[])
    {
        int x = 450;
        int y = 450;
        Program p = new Program();
        MyPanel panel = new MyPanel(x,y);
        panel.add(new Circle());
        panel.add(new Square());
        p.setSize(x,y);
        p.setVisible(true);
        p.add(panel);
        p.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

    }
}
