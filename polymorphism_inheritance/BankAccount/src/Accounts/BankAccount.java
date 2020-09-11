package Accounts;

public class BankAccount {
    private double balance;

    public BankAccount(double money) {
        System.out.println("Счет создан, баланс: " + money);
        this.balance = money;
    }

    public void putMoney (double money){
     if (money <= 0){
         System.out.println("ERROR try again");
     }else{
         balance += money;
         System.out.println("Вы внесли : "+ money + "\n" +"Баланс на счету :" + balance);
     }
    }

    public void takeMoney (double money){
        if(money <= 0 || money > balance){
            System.out.println("ERROR try again");
        }else{
            balance -= money;
            System.out.println("Вы сняли: " + money + "\n" + "Остаток на счету: " + balance);
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("Установлен баланс счета " + balance );
    }

    public double getBalance() {
        return balance;
    }

    public void balanceInfo(){
        System.out.println("Текуший баланс: " + balance);
    }
   // тут невнимательность забыл про получателя, извиняюсь
    public boolean send(BankAccount receiver, double amount){
       if(getBalance() < amount){
           System.out.println("Недостаточно средств");
           return false;
       }else{
           takeMoney(amount);
           receiver.putMoney(amount);
           System.out.println("Транзакция успешна");
           return true;
       }
    }
}
