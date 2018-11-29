package books;
import java.sql.*;
import java.util.ArrayList;
public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement preStmt = null;
    private ResultSet rs = null;

    public boolean connect() {
        try {
            for (int i = 0; i < 3; i++) {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/jachuraf", "jachuraf", "5XW6DZqZ9vap7DyH");
            }
        } catch (Exception ex)
        {
            return false;
        }

        if(conn!=null) return true;
        return false;

    }

    public ArrayList<Book> listBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from books");
            ResultSetMetaData metadata = rs.getMetaData();
            while (rs.next()) {
                books.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
                stmt = null;
            }
        }
        return books;
    }

    public Book searchByISBN(String ISBN) {
        Book b = null;
        try {
            String prepared = "SELECT * FROM books where ISBN=?";
            preStmt = conn.prepareStatement(prepared);
            preStmt.setString(1, ISBN);
            rs = preStmt.executeQuery();
            if(rs.next()) {
                b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            } else return null;
            } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
                rs = null;
            }
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException ex) {
                }
                preStmt = null;
            }
        }
        return b;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> b = new ArrayList<>();
        try {
            String prepared = "SELECT * FROM books where author like  ?";
            preStmt = conn.prepareStatement(prepared);
            preStmt.setString(1, "% "+author);
            rs = preStmt.executeQuery();

            while(rs.next()) {
                b.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
                rs = null;
            }
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException ex) {
                }
                preStmt = null;
            }
        }
        return b;
    }
    public boolean addBook(String ISBN, String name, String author, int year)
    {

        if(searchByISBN(ISBN)!=null)
        {
            return false;
        }
        try
        {
            String prepared = "INSERT INTO books VALUES (?,?,?,?)";
            preStmt = conn.prepareStatement(prepared);
            preStmt.setString(1,ISBN);
            preStmt.setString(2,name);
            preStmt.setString(3,author);
            preStmt.setInt(4,year);
            preStmt.execute();

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
                rs = null;
            }
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException ex) {
                }
                preStmt = null;
            }
        }
        return true;
    }
}
