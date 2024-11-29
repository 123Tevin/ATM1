import java.util.Calendar;
import java.util.UUID;

public class BaseTransaction implements TransactionInterface {
    private double amount;
    private Calendar date;
    private String transactionID;
    private BankAccount associatedAccount;

     public BaseTransaction(double amount) {
        this.amount = amount;
        this.date = Calendar.getInstance();
        this.transactionID = UUID.randomUUID().toString();
    }
    public void setAssociatedAccount(BankAccount account) {
         this.associatedAccount = account;
    }
    public BankAccount getAssociatedAccount() {
         return this.associatedAccount;
    }
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }
    @Override
    public abstract void apply(BankAccount ba);//Abstract method to be implemented by subclasses
    @Override
    public <BankAccount> void apply(BankAccount ba) {
        System.out.println("Base transaction does not modify the account.");
    }
}
