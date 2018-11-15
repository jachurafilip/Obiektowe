package lab6.cw1;

import java.awt.*;

public class Circle extends Shapes {
    private int x_,y_,r_;
    Circle(int x, int y, int r)
    {
        super();
        x_ = x;
        y_ = y;
        r_=r;

    }

    public void draw(Graphics2D g)
    {
       g.setColor(new Color(0,0,0));
        g.fillOval(x_,y_,r_,r_);

    }

    @Override
    public void setMargin(int x, int y) {
        x_+=x;
        y_+=y;
    }
    public boolean inRange(int x, int y)
    {
        return (x-x_)*(x-x_)+(y-y_)*(y-y_)<=r_*r_;
    }
}
