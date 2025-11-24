package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setUp()
    {
        account = new BankAccount();
    }

    @Test
    void constructorInitialisation()
    {
        account = new BankAccount("ACC12345", "David", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("David", account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorNegativeInitialisation()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "David", -1));
        assertEquals("Balance must be greater than 0.", ex.getMessage());
    }

    @Test
    void test_positiveDeposit()
    {
        account = new BankAccount("ACC12345", "David", 100);
        assertEquals(120, account.add(account.getBalance(),20));
    }

    @Test
    void test_NegativeZeroDeposit()
    {
        account = new BankAccount("ACC12345", "David", 100);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.add(account.getBalance(), 0));
        assertEquals("Deposit must be greater than 0.", ex.getMessage());
    }

    @Test
    void test_withdrawal()
    {
        account = new BankAccount("ACC12345", "David", 100);
        assertEquals(50, account.withdraw(account.getBalance(), 50));
    }

    @Test
    void test_NegativeZeroWithdrawal()
    {
        account = new BankAccount("ACC12345", "David", 100);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(account.getBalance(), -50));
        assertEquals("Withdrawal must be greater than 0.", ex.getMessage());
    }

}
