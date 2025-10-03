
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/employee_db"; // your database name
    private static final String USER = "postgres";       // your PostgreSQL username
    private static final String PASSWORD = "postgres"; // your PostgreSQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection(); // this will try to connect when you run the program
    }
}

