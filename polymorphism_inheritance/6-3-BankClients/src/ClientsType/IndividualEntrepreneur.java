package ClientsType;

public class  IndividualEntrepreneur extends Client{

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
        if(amount <= 1000 && amount > 0){
            double commision = amount * 0.01;
            System.out.println("Коммисия составила: " + commision);
            amount = getBalance()+amount-commision;
            super.putMoney(amount);
        }if(amount >= 1000){
            double commision = amount * 0.005;
            System.out.println("Коммисия составила: " + commision);
            amount = getBalance()+amount-commision;
            super.putMoney(amount);
        }else {
            System.out.println("Некоректный ввод");
        }
    }
}
