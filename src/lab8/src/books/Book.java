package books;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private int year;

    public Book(String ISBN, String name, String author, int year) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

