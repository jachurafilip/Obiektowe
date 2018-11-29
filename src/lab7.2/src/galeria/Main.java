package galeria;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    private Stage primaryStage;
    private String path;
    private ScrollPane sp;
    private TilePane tp;
    private Button btn;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        sp = new ScrollPane();
        tp = new TilePane();
        primaryStage.setTitle("Photos");

            path = "photos";

        primaryStage.getIcons().add(new Image("https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-128.png"));

        sp.setContent(tp);

        Button btn = new Button();
        tp.getChildren().add(btn);
        btn.setText("Choose directory");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tp.getChildren().clear();
                DirectoryChooser dc = new DirectoryChooser();
                File file = dc.showDialog(primaryStage);
                if(file!=null) {
                    path = file.getAbsolutePath();
                }
                else
                {
                    path = "photos";
                }
                primaryStage.getIcons().add(new Image("https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-128.png"));

                File folder = new File(path);
                File[] files = folder.listFiles();
                for(File f: files)
                {
                    if(f.getName().endsWith(".jpg")) {
                        ImageView imageView = createView(f);
                        if (imageView != null) {
                            tp.getChildren().addAll(imageView);
                        }
                    }
                }
                sp.setContent(tp);

                tp.getChildren().add(btn);

            }
        });
        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public ImageView createView(File imageFile)
    {
        ImageView view = null;
        try
        {
            Image img = new Image(new FileInputStream(imageFile),150,0,true,true);
            view = new ImageView(img);
            view.setFitHeight(150);
            view.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton().equals(MouseButton.PRIMARY))
                    {
                        if(event.getClickCount()==2)
                        {
                            try {
                                BorderPane borderPane = new BorderPane();
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(imageFile));
                                imageView.setImage(image);
                                Stage newStage = new Stage();
                                borderPane.setCenter(imageView);
                                newStage.setTitle(imageFile.getName());
                                Scene scene = new Scene(borderPane);
                                newStage.setScene(scene);
                                newStage.show();
                            } catch (FileNotFoundException ex)
                            {
                                System.out.println("Couldn't find the file");
                            }
                        }
                    }
                }
            });

        } catch (FileNotFoundException ex)
        {
            System.out.println("Couldn't find the file on path"+path);
        }
        return view;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
