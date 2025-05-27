import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    private static final String URL = "jdbc:sqlite:bank.db";

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false);

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitCount = debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditCount = creditStmt.executeUpdate();

                if (debitCount == 1 && creditCount == 1) {
                    conn.commit();
                    System.out.println("Transfer successful");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed, transaction rolled back");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error during transfer, transaction rolled back: " + e.getMessage());
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionExample te = new TransactionExample();
        te.transferMoney(1, 2, 200);
    }
}
