package ClientsType;

public class IndividualEntrepreneur extends Client {

    public IndividualEntrepreneur(double balance) {
        super(balance);
    }

    @Override
    public void info() {
        System.out.println("Info\n==========>\nПополнение с комиссией 1%," +
                "\nесли сумма меньше 1000 рублей. " +
                "\nИ с комиссией 0,5%, если сумма больше либо равна 1000 рублей." +
                "\nБаланс: " + getBalance());
    }

    @Override
    public void putMoney(double amount) {
        double commissionPercent;
        double commission;

        if (amount <= 1000 && amount > 0) {
            commissionPercent = 0.01;
        }
        if (amount >= 1000) {
            commissionPercent = 0.05;
        } else {
            System.out.println("Некоректный ввод");
            return;
        }
        commission = amount * commissionPercent;
        System.out.println("Коммисия составила: " + commission);
        amount = getBalance() + amount - commission;
        super.putMoney(amount);
    }
}
