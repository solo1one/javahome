package ClientsType;

public class NaturalPerson extends Client {
    public NaturalPerson(double balance){
        super(balance);
    }

    @Override
    public void info() {
        System.out.println( "Info\n==========>\nПополнение и снятие происходит без комиссии\nБаланс: " + getBalance());
    }


}
