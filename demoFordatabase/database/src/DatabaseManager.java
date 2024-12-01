
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USER = "COMP228_F24_soh_43";
    private static final String PASSWORD = "justastudent";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found: " + e.getMessage());
        }
    }

    private Connection connect() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addData(String firstName, String lastName, int age, String favoriteColor, String collegeProgram) {
        String query = "INSERT INTO comp228_demo (first_name, last_name, age, favorite_color, college_program) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);
            pstmt.setString(4, favoriteColor);
            pstmt.setString(5, collegeProgram);
            pstmt.executeUpdate();
            System.out.println("Data added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding data: " + e.getMessage());
        }
    }

    public void readData() {
        String query = "SELECT * FROM comp228_demo";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.printf("First Name: %s,\nLast Name: %s,\nAge: %d,\nFavorite Color: %s,\nCollege Program: %s%n", rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("favorite_color"), rs.getString("college_program"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }

    public void updateData(int id, String newFavoriteColor) {
        String query = "UPDATE comp228_demo SET favorite_color = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newFavoriteColor);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Data updated successfully." : "No row found with the specified ID.");
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    public void deleteData(int id) {
        String query = "DELETE FROM comp228_demo WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Data deleted successfully." : "No row found with the specified ID.");
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
}