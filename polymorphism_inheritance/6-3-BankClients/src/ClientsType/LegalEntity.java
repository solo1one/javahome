package ClientsType;

public class LegalEntity extends Client {

    private final double TAKE_COMMISSION_PERCENT = 0.01;

    public LegalEntity(double balance) {
        super(balance);
    }

    @Override
    public void info() {
        System.out.println("Info\n==========>\nСнятие с комиссией 1% \n" +
                "Баланс: " + getBalance());
    }

    @Override
    public boolean takeMoney(double amount) {
        double commission = amount * TAKE_COMMISSION_PERCENT;
        if (super.takeMoney(amount + commission)) {
            System.out.println("Коммисия составит: " + commission);
            System.out.println("Баланс после снятия комисси: " + getBalance());
            return true;
        }
        return false;
    }
}
