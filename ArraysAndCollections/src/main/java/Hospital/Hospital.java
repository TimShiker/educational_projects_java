package Hospital;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Hospital {

    private final static String ERROR = "Error. Temperature data must contain at least one element.";

    // this method generate temperatures of patients
    public static float[] generatePatientsTemperatures(int patientsCount) {

        if(patientsCount < 1){
            return null;
        }

        float minTemperature = 32f;
        float maxTemperature = 40f;
        float difference = maxTemperature - minTemperature;
        float[] patientsTemperatures = new float[patientsCount];

        MathContext context = new MathContext(3, RoundingMode.HALF_UP);
        BigDecimal patientTemperatureRounding;

        for(int i = 0; i < patientsTemperatures.length; i++){
            double patientTemperature = (Math.random() * difference) + minTemperature;
            patientTemperatureRounding = new BigDecimal(patientTemperature, context);

            patientsTemperatures[i] = patientTemperatureRounding.floatValue();

        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {

        if(temperatureData == null){
            return ERROR;
        }

        float sumAllPatientsTemperatures = 0f;
        float minTemperatureHealthyPatient = 36.2f;
        float maxTemperatureHealthyPatient = 36.9f;
        int countHealthyPatient = 0;

        String space = " ";
        StringBuilder stringBuilder = new StringBuilder();

        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal averageRounding;

        for(float patientTemperature : temperatureData){

            stringBuilder.append(patientTemperature + space);
            sumAllPatientsTemperatures += patientTemperature;

            if(patientTemperature >= minTemperatureHealthyPatient &&
                    patientTemperature <= maxTemperatureHealthyPatient){
                countHealthyPatient++;
            }
        }

        float average = sumAllPatientsTemperatures / (float) temperatureData.length;
        averageRounding = new BigDecimal(average, context);

        String report =
                "Patient temperatures: " + stringBuilder.toString().trim() +
                        "\nAverage temperature: " + averageRounding +
                        "\nNumber of healthy: " + countHealthyPatient;

        return report;
    }
}
