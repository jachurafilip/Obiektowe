package lab6.ksztalty;

import java.awt.*;

public class Triangle extends Shapes {
    private int  x[] = {110,160,140};
    private int y[] = {10,10,60};
    private Polygon triangle;
    Triangle()
    {
        super();
        triangle = new Polygon(x,y,3);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(0,0,0));
        g.fillPolygon(triangle);
    }

    @Override
    public void setMargin(int x_, int y_) {
        for(int i =0; i<3;i++)
        {
            triangle.xpoints[i]+=x_;
            triangle.ypoints[i]+=y_;
            x = triangle.xpoints;
            y = triangle.ypoints;
        }
    }

    @Override
    public boolean inRange(int x_, int y_) {
        return new Polygon(x,y,3).contains(x_,y_  );
    }
}
