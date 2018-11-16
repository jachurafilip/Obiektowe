package lab6.Wielomiany;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class MyPanel extends JPanel {
    private Box controls;
    private JPanel graphPanel;
    private JSlider aSlider, bSlider, cSlider;
    private JLabel aLabel, bLabel, cLabel;
    private int rangefrom = -20;
    private int rangeto=20;
    private int scale = 5;
    private double a, b, c, x, y;
    private static final int N = 500;
    private static final int A = 1;
    private static final int B = 0;
    private static final int C = 0;



    public MyPanel() {
        aSlider = new JSlider(JSlider.HORIZONTAL, -25, 25, A);
        aSlider.setMajorTickSpacing(1);
        aSlider.setMinorTickSpacing(5);
        aSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        bSlider = new JSlider(JSlider.HORIZONTAL, -10, 10, B);
        bSlider.setMajorTickSpacing(5);
        bSlider.setMinorTickSpacing(1);
        bSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        cSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, C);
        cSlider.setMajorTickSpacing(50);
        cSlider.setMinorTickSpacing(10);
        cSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        SliderListener listener = new SliderListener();
        aSlider.addChangeListener(listener);
        bSlider.addChangeListener(listener);
        cSlider.addChangeListener(listener);

        aLabel = new JLabel("a: 0");
        bLabel = new JLabel("b: 0");
        cLabel = new JLabel("c: 0");
        controls = new Box(BoxLayout.Y_AXIS);
        controls.add(aLabel);
        controls.add(aSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(bLabel);
        controls.add(bSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(cLabel);
        controls.add(cSlider);

        graphPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(N, N);
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int yp=0,wp=0,w=0,h=0;
                for (x = rangefrom; x <= rangeto; x++) {
                    yp =h;
                    wp = w;
                    y = a * x * x + b * x + c;
                    g.setColor(Color.black);
                    w = (int) (x * scale) + N / 2;
                    h = (int) (-y * scale) + N / 2;
                    g.drawLine(0,N/2,N,N/2);
                    g.drawLine(N/2,0,N/2,N);
                    if(wp!=0)
                    g.drawLine(w,h,wp,yp);
                }
            }
        };
        graphPanel.setBackground(Color.white);

        add(controls);
        add(graphPanel);
        listener.stateChanged(null);
    }

    public class SliderListener implements ChangeListener {
///
///Reads the user input via slider.
///

        @Override
        public void stateChanged(ChangeEvent event) {
            a = aSlider.getValue() / 5d;
            b = bSlider.getValue();
            c = cSlider.getValue();

            aLabel.setText("a: " + a);
            bLabel.setText("b: " + b);
            cLabel.setText("c: " + c);

            repaint();
        }
    }

}
