package books;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.print.*;
import java.util.ArrayList;


public class Controller {
    public Controller()
    {
      db.connect();
    }

    public void ShowAll()
    {
     ArrayList<Book> b = db.listBooks();
     for(Book b1: b) {
         System.out.println(b1.getName());
     }
    }

    public void ShowByISBN()
    {
        Book b = db.searchByISBN(show_by_ISBN.getText());
        System.out.println(b.getName());
        //TODO nie działa

    }
    public void ShowByAuthor()
    {

    }
    public void Add()
    {

    }



    private DB db = new DB();
    @FXML
    private Pane background;
    @FXML
    private Button show_all;
    @FXML
    private Button show_by_author;
    @FXML
    private Button show_by_ISBN;
    @FXML
    private TextField author;
    @FXML
    private TextField ISBN;
    @FXML
    private TextField add_ISBN;
    @FXML
    private TextField add_author;
    @FXML
    private TextField add_title;
    @FXML
    private TextField add_year;
    @FXML
    private Button add_book;




}
