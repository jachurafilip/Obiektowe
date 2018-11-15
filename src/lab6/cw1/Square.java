package lab6.cw1;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shapes {
    public void draw(Graphics2D g, int x, int y)
    {
        Rectangle2D.Float square = new Rectangle2D.Float(x,y,50,50);
        g.setColor(new Color(0,0,0));
        g.fill(square);
    }
}
