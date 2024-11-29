public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) { // Needed for reversal functionality
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew"+amount+".New balance: "+balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

