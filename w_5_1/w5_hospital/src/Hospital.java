import static java.lang.Math.round;

public class Hospital {
    public static void main(String[] args) {
        float [] patientTemp = new float[90];
        final int maxTemp = 40;
        final int minTemp = 32;
        int health = 0;
        float tempSum = 0.0f;
        float aveTemp = 0.0f;


        for (int i = 0; i < patientTemp.length ; i++){
            patientTemp[i] = (float)((Math.random()*(maxTemp-minTemp)) + minTemp);
            System.out.print(" -=#1 " + i + " t " + patientTemp[i]+ "#=-" );
            if (patientTemp[i] > 36.2 && patientTemp[i] < 36.9){
                health++;
            }
           tempSum += patientTemp[i];
        }
        aveTemp = tempSum/patientTemp.length;
        System.out.println('\n' + "средняя температура пациентов " + aveTemp);
        System.out.println("здоровых пациентов " + health);
    }
}
