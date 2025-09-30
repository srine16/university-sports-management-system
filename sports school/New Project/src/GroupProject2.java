import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupProject2 {

    public static List<String> ReadFromDB() {
        String url = "jdbc:sqlite:C:\\Users\\sunji\\eclipse-workspace\\New Project\\src\\GP2.db"; // Ensure correct path
        String sql = "SELECT * FROM Sports";
        List<String> activities = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet results = ps.executeQuery()) {

            System.out.println("Connected to database successfully!");

            // Store results in list
            while (results.next()) {
                String activity = results.getString("Sports Activities"); // Adjust column name
                activities.add(activity);
                System.out.println(activity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities; // Return list instead of ResultSet
    }
}
