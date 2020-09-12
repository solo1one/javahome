import ClientsType.Client;
import ClientsType.IndividualEntrepreneur;
import ClientsType.LegalEntity;
import ClientsType.NaturalPerson;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello there !!!");

        Client jonatan = new NaturalPerson(30000);
        jonatan.takeMoney(1000);
        jonatan.info();

        System.out.println("\n\n\n======================zara");
        Client zara = new IndividualEntrepreneur(10000);
        zara.info();
        zara.putMoney(0);


        System.out.println("\n\n\n======================Legal");
        Client legal = new LegalEntity(100000);
        legal.info();
        legal.takeMoney(10000);
        legal.info();
    }
}
