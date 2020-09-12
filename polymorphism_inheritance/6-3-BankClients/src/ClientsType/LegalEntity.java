package ClientsType;

public class LegalEntity extends Client{


    public LegalEntity(double balance) {
        super(balance);
    }

    @Override
    public void info() {
        System.out.println("Info\n==========>\nСнятие с комиссией 1% \n" +
                "Баланс: " + getBalance());
    }

    @Override
    public void takeMoney(double amount) {
        double commission = amount * 0.01;
        if ( amount + commission <= getBalance() && amount > 0) {
            super.takeMoney(amount);
            setBalance(getBalance()-commission);
            System.out.println("Коммисия составит: " + commission);
            System.out.println("Баланс после снятия комисси: " + getBalance());
        }else {
            System.out.println("Некоректный ввод");
        }
    }
}
