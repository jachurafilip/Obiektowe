package lab6.ksztalty;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {
    public LinkedList<Shapes> shapes = new LinkedList<>();

    MyPanel(LinkedList<Shapes> s)
    {
        shapes.addAll(s);
    }
    MyPanel(){}

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Program.WIDTH, Program.HEIGHT);
        for (var s : shapes) {
            s.draw(g2d);
        }

    }
}
