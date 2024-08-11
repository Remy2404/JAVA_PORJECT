package Chapter11_Reading.myDB;
import java.sql.*;
import Chapter11_Reading.src.EX9;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/banking_system";
    private static final String USER = "root";
    private static final String PASS = "Ramy2404";

    // Method to add a new account
    public void addAccount(int accountNo, String name, int password, double balance) {
        String sql = "INSERT INTO accounts (account_no, name, password, balance) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountNo);
            pstmt.setString(2, name);
            pstmt.setInt(3, password);
            pstmt.setDouble(4, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve an account based on account number and password
    public EX9 getAccount(int accountNo, int password) {
        String sql = "SELECT * FROM accounts WHERE account_no = ? AND password = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountNo);
            pstmt.setInt(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new EX9(rs.getInt("account_no"), rs.getString("name"), rs.getInt("password"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update the balance after a transaction
    public void updateBalance(int accountNo, double newBalance) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_no = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getMaxAccountNumber() {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxAccountNumber'");
    }
}