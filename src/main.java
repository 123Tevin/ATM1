import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // Step 1: Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.0);
        System.out.println("Initial Account Balance: " + account.getBalance());

        // Step 2: Create a list to hold transactions
        List<BaseTransaction> transactions = new ArrayList<>();

        // Step 3: Add transactions
        transactions.add(new DepositTransaction(200.0));
        transactions.add(new WithdrawalTransaction(150.0));
        transactions.add(new WithdrawalTransaction(1200.0)); // Overdraft attempt

        // Step 4: Apply transactions and print details
        for (BaseTransaction transaction : transactions) {
            transaction.printTransactionDetails();
            transaction.apply(account);
        }
        // Step 5: Print the final account balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}

    public static void main(String[] args) {
        // Step 1: Create a bank account
        BankAccount account = new BankAccount(1000.0);
        System.out.println("Initial Account Balance: " + account.getBalance());

        // Step 2: Create a withdrawal transaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200.0);

        // Step 3: Apply the transaction
        withdrawal.apply(account);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Step 4: Reverse the transaction
        System.out.println("Attempting to reverse the withdrawal...");
        withdrawal.reverse();

        // Step 5: Try reversing again
        System.out.println("Attempting to reverse the withdrawal again...");
        withdrawal.reverse();

        // Step 6: Print final account balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }


    public static void main(String[] args) {
        // Step 1: Create a bank account with an initial balance
        BankAccount account = new BankAccount(100.0);

        // Step 2: Create a withdrawal transaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200.0);

        // Step 3: Apply the withdrawal with exception handling
        System.out.println("Attempting withdrawal with exception handling...");
        withdrawal.applyWithExceptionHandling(account);

        // Step 4: Check the account balance after the transaction
        System.out.println("Final Account Balance: " + account.getBalance());

        // Step 5: Attempt to reverse the withdrawal
        System.out.println("Attempting to reverse the withdrawal...");
        withdrawal.reverse();
    }




    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount account = new BankAccount("123456", 500.0);
        System.out.println("Initial Balance: " + account.getBalance());

        // Create a DepositTransaction object
        DepositTransaction deposit = new DepositTransaction(200.0);
        System.out.println("\nTesting DepositTransaction...");
        testTransaction(deposit, account);

        // Create a WithdrawalTransaction object
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100.0);
        System.out.println("\nTesting WithdrawalTransaction...");
        testTransaction(withdrawal, account);

        // Test insufficient funds during withdrawal
        System.out.println("\nTesting WithdrawalTransaction with insufficient funds...");
        WithdrawalTransaction insufficientWithdrawal = new WithdrawalTransaction(700.0);
        testTransaction(insufficientWithdrawal, account);

        // Test reverse functionality for WithdrawalTransaction
        System.out.println("\nTesting reverse() on a WithdrawalTransaction...");
        if (withdrawal.reverse(account)) {
            System.out.println("Withdrawal reversed successfully.");
        } else {
            System.out.println("Withdrawal reversal failed.");
        }
        System.out.println("Final Balance: " + account.getBalance());

        // Demonstrate type casting
        System.out.println("\nDemonstrating type casting...");
        BaseTransaction baseTransaction = deposit; // Upcasting
        System.out.println("BaseTransaction (Deposit):");
        baseTransaction.printTransactionDetails();
        baseTransaction = withdrawal; // Upcasting
        System.out.println("BaseTransaction (Withdrawal):");
        baseTransaction.printTransactionDetails();
    }

    // Utility method to test transactions
    private static void testTransaction(BaseTransaction transaction, BankAccount account) {
        transaction.printTransactionDetails();
        try {
            transaction.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println("Balance after transaction: " + account.getBalance());
    }


