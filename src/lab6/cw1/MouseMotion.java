package lab6.cw1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener, MouseListener {
    private int x,y;
    private MyPanel panel;
    private Shapes found;

    public MouseMotion(MyPanel panel) {
        this.panel = panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        found = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(found!=null)
        {
            found.setMargin(e.getX()-x,e.getY()-y);
            x = e.getX();
            y = e.getY();
            panel.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        found = null;
        x = e.getX();
        y = e.getY();
        System.out.println(x+" "+y);
        for(var sh: panel.shapes)
        {
            if(sh.inRange(x,y))
            {
                found = sh;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        found = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
