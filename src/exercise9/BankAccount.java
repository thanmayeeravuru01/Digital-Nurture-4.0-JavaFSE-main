package exercise9;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal of ₹" + amount + " failed. Insufficient balance: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + ". Remaining balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
