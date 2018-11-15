package lab6.cw1;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shapes {
    public void draw(Graphics2D g, int x, int y)
    {
       Ellipse2D.Float circle = new Ellipse2D.Float(x,y,50,50);
        g.setColor(new Color(0,0,0));
        g.fill(circle);

    }
}
