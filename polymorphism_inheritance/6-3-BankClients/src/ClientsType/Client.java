package ClientsType;

abstract public class Client {
    private double balance;

    Client(double balance) {
        this.balance = balance;
    }

    public abstract void info();

    public void takeMoney(double amount) {
        if (amount > getBalance() || amount <= 0) {
            System.out.println("Некоректный ввод или недостаточно средств");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Вы сняли: " + amount + "\nБаланс: " + getBalance());
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
