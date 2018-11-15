package lab6.cw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class MyPanel extends JPanel implements MouseMotionListener, MouseListener {
    public LinkedList<Shapes> shapes = new LinkedList<>();
    public int x,y;
    private int xmouse, ymouse;

    MyPanel(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int i=0;
        int j=0;
        for(var s: shapes)
        {
            s.draw(g2d,i,j);
            i+=50;
            if(i>x)
            {
                i = 0;
                j+=50;
            }
        }
    }

    public void add(Shapes s)
    {
        shapes.add(s);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y= e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX()-xmouse;
        int dy = e.getY()-ymouse;
        for(var s: shapes)
        {

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
