import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeOperations {

    // Add Employee
    public void addEmployee(String name, String email, double salary) {
        String sql = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);

            ps.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {
        String sql = "SELECT * FROM employee";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("email") + " | " +
                                   rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Employee Salary
    public void updateEmployeeSalary(int id, double newSalary) {
        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, newSalary);
            ps.setInt(2, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
