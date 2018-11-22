package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public double a,b,c,d;

    public void setValues(ActionEvent e)
    {
        try {
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            c = Integer.parseInt(field3.getText());
            d = Integer.parseInt(field4.getText());
        } catch(NumberFormatException ex)
        {
            
        }
        System.out.println(a);
        System.out.println("Test");
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





}
