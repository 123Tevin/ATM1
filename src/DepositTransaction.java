import javax.sound.midi.Soundbank;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    public void apply(BankAccount ba) {
        ba.deposit(getAmount());
        System.out.println("Deposited" + getAmount() + "into account.");
    }
}
