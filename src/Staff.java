import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Staff {
    private int staffId;

    public Staff(int staffId) {
        this.staffId = staffId;
    }

    public void bookResource(int resourceId) {
        String sql = "INSERT INTO bookings (staff_id, resource_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, staffId);
            stmt.setInt(2, resourceId);
            stmt.executeUpdate();
            System.out.println("Resource booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void unbookResource(int bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            stmt.executeUpdate();
            System.out.println("Resource unbooked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
