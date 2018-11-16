package lab6.Wielomiany;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class MyPanel extends JPanel {
    private Box controls;
    private JPanel graphPanel;
    private JSlider aSlider, bSlider, cSlider, dSlider,fromSlider,toSlider,samplingSlider;
    private JLabel aLabel, bLabel, cLabel,dLabel,fromLabel,toLabel,samplingLabel;
    private int scale = 5;
    private double a, b, c, d,x, y,rangefrom,rangeto;
    private static final int N = 500;
    private static final int A = 10;
    private static final int B = 0;
    private static final int C = 0;
    private static final int D = 0;


    public MyPanel() {
        samplingSlider = new JSlider(JSlider.HORIZONTAL, 1, 50, 10);
        samplingSlider.setMajorTickSpacing(1);
        samplingSlider.setMinorTickSpacing(5);
        samplingSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        fromSlider = new JSlider(JSlider.HORIZONTAL, -30, 30, -20);
        fromSlider.setMajorTickSpacing(1);
        fromSlider.setMinorTickSpacing(5);
        fromSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        toSlider = new JSlider(JSlider.HORIZONTAL, -30, 30, 20);
        toSlider.setMajorTickSpacing(1);
        toSlider.setMinorTickSpacing(5);
        toSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        aSlider = new JSlider(JSlider.HORIZONTAL, -25, 25, A);
        aSlider.setMajorTickSpacing(1);
        aSlider.setMinorTickSpacing(5);
        aSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        bSlider = new JSlider(JSlider.HORIZONTAL, -50, 50, B);
        bSlider.setMajorTickSpacing(5);
        bSlider.setMinorTickSpacing(1);
        bSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        cSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, C);
        cSlider.setMajorTickSpacing(50);
        cSlider.setMinorTickSpacing(10);
        cSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        dSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, D);
        dSlider.setMajorTickSpacing(50);
        dSlider.setMinorTickSpacing(10);
        dSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        SliderListener listener = new SliderListener();
        aSlider.addChangeListener(listener);
        bSlider.addChangeListener(listener);
        cSlider.addChangeListener(listener);
        dSlider.addChangeListener(listener);
        fromSlider.addChangeListener(listener);
        toSlider.addChangeListener(listener);
        samplingSlider.addChangeListener(listener);

        samplingLabel = new JLabel("One unit is equal to 10 pixels");
        aLabel = new JLabel("a: 0");
        bLabel = new JLabel("b: 0");
        cLabel = new JLabel("c: 0");
        dLabel = new JLabel("d: 0");
        fromLabel = new JLabel("From: -20");
        toLabel = new JLabel("To: 20");
        controls = new Box(BoxLayout.Y_AXIS);
        controls.add(aLabel);
        controls.add(aSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(bLabel);
        controls.add(bSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(cLabel);
        controls.add(cSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(dLabel);
        controls.add(dSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(toLabel);
        controls.add(toSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(fromLabel);
        controls.add(fromSlider);
        controls.add(Box.createRigidArea(new Dimension(0, 20)));
        controls.add(samplingLabel);
        controls.add(samplingSlider);

        graphPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(N, N);
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int yp=0,wp=0,w=0,h=0;
                g.setColor(Color.red);
                g.drawLine(0,N/2,N,N/2);
                g.drawLine(N/2,0,N/2,N);
                for (x = rangefrom; x <= rangeto; x++) {
                    yp =h;
                    wp = w;
                    y = (a * x * x * x + b * x*x + c*x+d);
                    g.setColor(Color.black);
                    w = (int) (x*scale) + N / 2;
                    h = (int) (-y*scale) + N / 2;
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
            a = aSlider.getValue() / 10d;
            b = bSlider.getValue() / 10d;
            c = cSlider.getValue() /10d;
            d = dSlider.getValue();
            rangefrom = fromSlider.getValue();
            rangeto = toSlider.getValue();
            scale = samplingSlider.getValue();

            aLabel.setText("a: " + a);
            bLabel.setText("b: " + b);
            cLabel.setText("c: " + c);
            dLabel.setText("d: "+d);
            fromLabel.setText("From: "+rangefrom);
            toLabel.setText("To: "+rangeto);
            samplingLabel.setText("One unit is equal to "+scale+" pixels");

            repaint();
        }
    }

}
