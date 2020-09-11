import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;

public class Main {
    public static void main(String[] args) {

        BankAccount standardAccount = new BankAccount(1200);
        standardAccount.balanceInfo();
        standardAccount.putMoney(2000);
        standardAccount.takeMoney(1000);
        standardAccount.setBalance(99999);
        System.out.println("\n");

        DepositAccount depositAccount = new DepositAccount(23423);
        depositAccount.takeMoney(1000);
        depositAccount.send(standardAccount,5000);
        depositAccount.putMoney(2200);
        depositAccount.balanceInfo();
        depositAccount.takeMoney(1000);
        System.out.println("\n");

        CardAccount cardAccount = new CardAccount(8000);
        cardAccount.takeMoney(1000);
        cardAccount.send(standardAccount,1000);
        cardAccount.balanceInfo();



    }
}
