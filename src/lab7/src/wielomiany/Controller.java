package wielomiany;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private LinkedList<Line> chart = new LinkedList<>();
    public double a,b,c,d,y=0,yprev, xprev,step=0.1,scale = 10,rangefrom,rangeto;
    private final static int N = 300;


    public void setValues(ActionEvent e)
    {
        y=0;
        error.setText("");


        wykres.getChildren().clear();
        chart.clear();
        chart.add(new Line(0,N,600,N));
        chart.add(new Line(N,0,N,600));
        try {
            if(field1.getText().isEmpty()) {
                a = 0;
            }
            else {
                a = Double.parseDouble(field1.getText());
            }
            if(field2.getText().isEmpty()) {
                b = 0;
            }
            else {
                b = Double.parseDouble(field2.getText());
            } if(field3.getText().isEmpty()) {
                c = 0;
            }
            else {
                c = Double.parseDouble(field3.getText());
            } if(field4.getText().isEmpty()) {
                d = 0;
            }
            else {
                d = Double.parseDouble(field4.getText());
            }
            if(from.getText().isEmpty()) {
                from.setText("-10");
                rangefrom = -10;
            }
            else {
                rangefrom = Double.parseDouble(from.getText());
            }
            if(to.getText().isEmpty()) {
                to.setText("10");
                rangeto=10;
            }
            else {
                rangeto = Double.parseDouble(to.getText());
            }
            if(samp.getText().isEmpty()) {
                samp.setText("10");
                step=0.1;
            }
            else {
               step = 1/Double.parseDouble(samp.getText());
            }
            if(scale_.getText().isEmpty()) {
                scale_.setText("10");
                scale = 10;
            }
            else {
                scale = Double.parseDouble(scale_.getText());
            }
        } catch(NumberFormatException ex)
        {
            error.setText("Wprowadzono niepoprawne wartości!");
            field1.setText("0");
            field2.setText("0");
            field3.setText("0");
            field4.setText("0");
            from.setText("-10");
            to.setText("10");
            samp.setText("10");
            scale_.setText("10");
        }
        for(double x=rangefrom; x<=rangeto;x+=step) {

            yprev = y;
            xprev = x - step;
            y = a * x * x * x + b * x * x + c * x + d;
            if (yprev == 0) {
            }
        else {
                if(x*scale>wykres.getHeight() || -x*scale>wykres.getHeight()) {
                    error.setText("Skala albo zakres zbyt duży, wykres nie został narysowany. ");
                    break;
                }
                chart.add(new Line(xprev * scale + N, -yprev *scale+ N, x * scale + N, -y *scale+ N));
            }
        }
        for(int x = (int)rangefrom; x<=(int)rangeto;x++ ) {
            if(x*scale<N) {
                chart.add(new Line(N + scale * x, N - 5, N + scale * x, N + 5));
                chart.add(new Line(N - 5, N + scale * x, N + 5, N + scale * x));
            }
        }
        for(Line l: chart) {
            wykres.getChildren().add(l);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private Button button;
    @FXML
    private Pane background;
    @FXML
    private Pane wykres;
    @FXML
    private Label error;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField samp;
    @FXML
    private TextField scale_;





}
