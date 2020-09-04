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
        System.out.println("Комиссия составила: " + commission);

    }
   //не стал создавать отдельный метод для расчета комиссии или стоило?

    public boolean accountsTransaction(BankAccount receiver, double amount){
        double commission = (amount * COMMISSION_PERCENT) / 100;
        amount += commission;
        if(amount < getBalance()){
            System.out.println("Комиссия составила: " + commission);
        }else {
            System.out.println("Транзакция по карте не проведена");
        }
        return super.accountsTransaction(receiver,amount);
    }
}
