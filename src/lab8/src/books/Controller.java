package books;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.print.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {

    public Controller()  {
            db = new DB();
            connection = db.connect();

    }

    public boolean isConnection() {
        return connection;
    }

    public void ShowAll()
    { String toPrint="\tISBN \t\t TITLE \t\t\t AUTHOR \t\t\t YEAR\n____________________________________________________________________________________________\n";
     ArrayList<Book> books = db.listBooks();
     for(Book b: books) {
         toPrint = toPrint+b.getISBN()+", "+b.getName()+", "+b.getAuthor()+", "+b.getYear()+"\n";
     }
     title.setText("Show all books");
     print.setText(toPrint);
    }

    public void ShowByISBN()
    {
        String toPrint="\tISBN \t\t TITLE \t\t\t AUTHOR \t\t\t YEAR\n____________________________________________________________________________________________\n";
        Book b = db.searchByISBN(ISBN.getText());
        if(b==null)
        {
            return;
        }
        toPrint=toPrint+b.getISBN()+", "+b.getName()+", "+b.getAuthor()+", "+b.getYear()+"\n";
        title.setText("Show book with ISBN: "+ISBN.getText());
        print.setText(toPrint);

    }
    public void ShowByAuthor()
    {
        String toPrint="\tISBN \t\t TITLE \t\t\t AUTHOR \t\t\t YEAR\n____________________________________________________________________________________________\n";

        ArrayList<Book> books = db.searchByAuthor(author.getText());
        if(books == null)
        {
            return;
        }
        for(Book b: books)
        {
            toPrint = toPrint+b.getISBN()+", "+b.getName()+", "+b.getAuthor()+", "+b.getYear()+"\n";
        }
        title.setText("Show book of: "+author.getText());
        print.setText(toPrint);

    }
    public void Add()
    {
        String toPrint="\tISBN \t\t TITLE \t\t\t AUTHOR \t\t\t YEAR\n____________________________________________________________________________________________\n";
        boolean added;
        try {
           added = db.addBook(add_ISBN.getText(), add_title.getText(), add_author.getText(), Integer.parseInt(add_year.getText()));
           if(added)
           {
               title.setText("Added");
               toPrint=toPrint+add_ISBN.getText()+", "+add_title.getText()+", "+add_author.getText()+", "+add_year.getText();
               print.setText(toPrint);
           }
           else
           {
               title.setText("Not added - already exists");
               print.setText("");
           }
        } catch (NumberFormatException e)
        {
            title.setText("Year must be an integer!");
            print.setText("");
        }
    }


    private boolean connection;
    private DB db;
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
    @FXML
    private Label title;
    @FXML
    private TextArea print;

}
