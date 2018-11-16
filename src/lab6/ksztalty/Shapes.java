package lab6.ksztalty;

import java.awt.*;

public abstract class Shapes {
    public abstract void draw(Graphics2D g);
    public abstract void setMargin(int x, int y);
    public abstract boolean inRange(int x, int y);

}
