package lab6.cw1;

import java.awt.*;

public abstract class Shapes {
    int x,y;
    public abstract void draw(Graphics2D g, int x, int y);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
