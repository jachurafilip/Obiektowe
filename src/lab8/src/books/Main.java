package books;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
             Parent root = loader.load();
             Controller c =loader.getController();
             if(c.isConnection()) {
                 primaryStage.setScene(new Scene(root, 800, 600));


             }
             else
             {
                TilePane tp = new TilePane();
                Label error = new Label();
                primaryStage.setScene(new Scene(tp,800,600));
                tp.getChildren().add(error);
                error.setText("Unable to establish connection with database - program needs to terminate");

             }
            primaryStage.setTitle("Books");
            primaryStage.show();
        }


    public static void main(String[] args) {

        launch(args);


    }
}
