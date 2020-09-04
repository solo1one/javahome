package Accounts;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

    private static final LocalDate today = LocalDate.now();
    private static LocalDate lastAddDepositDay = today;
    private static long period;

    public DepositAccount(double money) {
        super(money);
    }

    public void putMoney(double money){
        if(money <= 0){
            System.out.println("ERROR try again");
        }else{
            lastAddDepositDay=today.plusMonths(1);
            period = ChronoUnit.DAYS.between(today,lastAddDepositDay);
            super.putMoney(money);
        }
    }

    public void takeMoney(double money){
            if (today.isAfter(lastAddDepositDay)||today.isEqual(lastAddDepositDay)){
                super.takeMoney(money);
            }else {
                System.out.println("Операция не доступна до оканчания периода " + period + " дней");
            }
    }


    public double getBalance (){
        return super.getBalance();
    }

    public void balanceInfo(){
        System.out.println("Депозитарный, счет средства можно снять после "+ period + " дней" );
        super.balanceInfo();
    }

    public boolean accountsTransaction (BankAccount receiver,double amount){
        if (today.isAfter(lastAddDepositDay)||today.isEqual(lastAddDepositDay)){
            return super.accountsTransaction(receiver,amount);
        }else {
            System.out.println("Депозитарный период "+ period + " дней транзакция невозможна");
            return false;
        }
    }


}
