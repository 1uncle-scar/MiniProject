import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    private String Admins;
    private String password;

    public Admin(String Admins, String password) {
        this.Admins = Admins;
        this.password = password;
    }

    // Method to verify admin credentials
    public boolean verifyCredentials() {
        String sql = "SELECT * FROM Admins WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.Admins);
            pstmt.setString(2, this.password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if admin exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to add a student
    public void addStudent(String name, String studentClass) {
        String sql = "INSERT INTO Students (name, class) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, studentClass);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to remove a student
    public void removeStudent(int studentId) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            System.out.println("Student removed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add staff
    public void addStaff(String name, String department) {
        String sql = "INSERT INTO Staff (name, department) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.executeUpdate();
            System.out.println("Staff added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to remove staff
    public void removeStaff(int staffId) {
        String sql = "DELETE FROM Staff WHERE staff_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, staffId);
            pstmt.executeUpdate();
            System.out.println("Staff removed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
