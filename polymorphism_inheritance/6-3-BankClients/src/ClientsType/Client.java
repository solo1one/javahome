package ClientsType;

abstract public class Client {
    private double balance;

    Client(double balance) {
        this.balance = balance;
    }

    public abstract void info();

    public boolean takeMoney(double amount) {
        if (amount > getBalance() || amount <= 0) {
            System.out.println("Некоректный ввод или недостаточно средств");
            return false;
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Снятие: " + amount + "\nБаланс: " + getBalance());
            return true;
        }
    }

    public void putMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Некоректный ввод");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Вы внесли: " + amount + "\n Баланс: " + getBalance());
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
