package Accounts;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

    private LocalDate lastAddDepositDay = LocalDate.now();

    public DepositAccount(double money) {
        super(money);
    }

    public void putMoney(double money){
        if(money <= 0){
            System.out.println("ERROR try again");
        }else{
            lastAddDepositDay=LocalDate.now().plusMonths(1);
            super.putMoney(money);
        }
    }

    public void takeMoney(double money){
            if (LocalDate.now().isAfter(lastAddDepositDay)||LocalDate.now().isEqual(lastAddDepositDay)){
                super.takeMoney(money);
            }else {
                System.out.println("Операция не доступна до оканчания периода " + period() + " дней");
            }
    }

     // метод создается для того что бы при каждом обращении к period иметь актуальную дату
    //  понял спасибо, а то я даже не подумал об этом
    private long period(){
        return ChronoUnit.DAYS.between(LocalDate.now(),lastAddDepositDay);
    }

    public void balanceInfo(){
        System.out.println("Депозитарный, счет средства можно снять после "+ period() + " дней" );
        super.balanceInfo();
    }

       // то есть весь этот код ниже писал напрасно, даже сделал хуже(в плане производительности и простоты)
      //  он исполнися как должно без различных дополнений
     //   т.к. условия уже прописаны в takeMoney и он лишь продублировал действия которые не нужны
    //    я правильно понял свою ошибку?
}
