public class WithdrawalTransaction extends BaseTransaction {
    private double shortfall; //Tr
    private boolean isReversed;//Tracks whether the transaction has been reversed
    private double previousBalance; //Stores the account's balance before withdrawal

    public WithdrawalTransaction(double amount) {
        super(amount);
        this.shortfall=0.0;
        this.isReversed = false;//Initially, the transaction is not reversed
    }


    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() >= getAmount()) {
            previousBalance = ba.getBalance();//Save the current balance before withdrawal
            ba.withdraw(getAmount());//Perform the withdrawal
            setAssociatedAccount(ba);//Associate the transaction with the account
            System.out.println("Withdrew " + getAmount() + " from account.");
        } else if(ba.getBalance()>0){
            previousBalance = ba.getBalance();
            shortfall = getAmount() - ba.getBalance();
            ba.withdraw(ba.getBalance());
            System.out.println("Insufficient funds for withdrawal of " + getAmount());
        }else{
            throws new InsufficientFundsException("Insufficient funds for withdrawal. Balance: "+ba.getBalance());
        }
    }

    //Overloaded apply() with exception handling
    public void applyWithExceptionHandling(BankAccount ba){
        try{
            apply(ba);
        }catch (InsufficientFundsException e){
            System.out.println("Exception caught: "+ e.getMessage());
        }finally{
            System.out.println("Transaction attempt completed.");
        }
    }

    public boolean reverse() {
        //Check if the transaction is already reversed or not associated
        if (isReversed) {
            System.out.println("Transaction already reversed. ");
            return false;
        }
        if (getAssociatedAccount() == null) {
            System.out.println("No account associated with this transaction.");
            return false;
        }
        getAssociatedAccount().setBalance(previousBalance);
        isReversed = true; //Mark the transaction as reversed
        System.out.println("Withdrawal reversed. Account balance restored to:" + previousBalance);
        return true;
    }
}
