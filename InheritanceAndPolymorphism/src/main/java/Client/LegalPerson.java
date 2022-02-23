package Client;

public class LegalPerson extends Client {

    private double amount;
    private final double commissionPercentage = 1;

    public LegalPerson() {
    }

    public LegalPerson(double amount) {
        this.amount = amount;
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + getCommission(amountToTake));
    }

    @Override
    public void publicInformationAboutCondition() {

        System.out.println("\nConditions for companies.\n" +
                "Replenishment occurs without commission, and withdrawal - with a commission in 1%.\n" +
                "Your account balance = " + getAmount() + "\n");
    }

    private double getCommission(double amountToTake) {
        return amountToTake * commissionPercentage / 100;
    }

}
