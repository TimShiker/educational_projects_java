package Client;

public class IndividualBusinessman extends Client {

    private double amount;

    public IndividualBusinessman() {
    }

    public IndividualBusinessman(double amount) {
        this.amount = amount;
    }

    @Override
    public void put(double amountToPut) {

        double commissionPercentage;
        double amountToDetermineCommission = 1000;

        if (amountToPut < amountToDetermineCommission) {
            commissionPercentage = 1;
            super.put(amountToPut - getCommission(amountToPut, commissionPercentage));
        } else if (amountToPut >= amountToDetermineCommission) {
            commissionPercentage = 0.5;
            super.put(amountToPut - getCommission(amountToPut, commissionPercentage));
        }
    }

    @Override
    public void publicInformationAboutCondition() {
        System.out.println("\nConditions for individual businessman.\n" +
                "Replenishment occurs with a commission of 1% if the amount is less than 1000 rubles.\n" +
                "Replenishment occurs with a commission of 0.5% if the amount " +
                "is greater than or equal to 1000 rubles.\n" +
                "Your account balance = " + getAmount() + "\n");
    }

    private double getCommission(double amountToTake, double commissionPercentage) {
        return amountToTake * commissionPercentage / 100;
    }
}
