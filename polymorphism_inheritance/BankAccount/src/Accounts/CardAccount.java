package Accounts;

public class CardAccount extends BankAccount {

    private final double COMMISSION_PERCENT = 1;

    public CardAccount(double money) {
        super(money);
    }

    public void takeMoney(double money) {
        double commission = (money * COMMISSION_PERCENT) / 100;
        money += commission;
        super.takeMoney(money);
    }

    public boolean send(BankAccount receiver, double amount){
        double commission = (amount * COMMISSION_PERCENT) / 100;
        amount += commission;
        return super.send(receiver,amount);
    }
}
