package lab6.ksztalty;

import javax.swing.*;
import java.util.LinkedList;

public class Program extends JFrame{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public Program(){
        super("Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
    }

    public static void main(String[] argv){
        LinkedList<Shapes> list = new LinkedList<>();


        list.add(new Square(10,10,50));
        list.add(new Circle(100,50,50));
        list.add(new Triangle());
        MyPanel panel = new MyPanel(list);
        MouseMotion mouseMotion = new MouseMotion(panel);
        Program frame = new Program();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

    }
}
