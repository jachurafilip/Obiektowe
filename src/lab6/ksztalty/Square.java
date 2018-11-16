package lab6.ksztalty;

import java.awt.*;

public class Square extends Shapes {
    private int x_,y_,a_;
    Square(int x, int y, int a)
    {
        super();
        x_=x;
        y_ =y;
        a_=a;
    }
    public void setMargin(int x, int y)
    {
        x_+=x;
        y_+=y;

    }
    public boolean inRange(int x, int y)
    {
        return (x <= x_ + a_ && x >= x_ && y <= y_+a_ && y >= y_);
    }
    public void draw(Graphics2D g)
    {
        g.setColor(new Color(0,0,0));
        g.fillRect(x_,y_,a_,a_);
    }


}
