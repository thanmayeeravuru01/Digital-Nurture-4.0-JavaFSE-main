import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100);  // Arrange
    }

    @Test
    public void testWithdraw() {
        account.withdraw(40);            // Act
        assertEquals(60, account.getBalance()); // Assert
    }

    @Test
    public void testDeposit() {
        account.deposit(50);             // Act
        assertEquals(150, account.getBalance()); // Assert
    }

    @After
    public void tearDown() {
        account = null;
    }
}
