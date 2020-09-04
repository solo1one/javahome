import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;

public class Main {
    public static void main(String[] args) {

        BankAccount standartAccount = new BankAccount(1200);
        standartAccount.balanceInfo();
        standartAccount.putMoney(2000);
        standartAccount.takeMoney(1000);
        standartAccount.setBalance(9999999);
        System.out.println("\n");

        DepositAccount depositAccount = new DepositAccount(23423);
        depositAccount.takeMoney(1000);
        depositAccount.accountsTransaction(standartAccount,5000);
        depositAccount.putMoney(2200);
        depositAccount.balanceInfo();
        depositAccount.takeMoney(1000);
        System.out.println("\n");

        CardAccount cardAccount = new CardAccount(8000);
        cardAccount.takeMoney(1000);
        cardAccount.accountsTransaction(standartAccount,9100);
        cardAccount.balanceInfo();



    }
}
