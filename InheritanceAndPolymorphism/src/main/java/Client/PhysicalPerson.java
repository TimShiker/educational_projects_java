package Client;

public class PhysicalPerson extends Client {

    private double amount;

    public PhysicalPerson() {
    }

    public PhysicalPerson(double amount) {
        this.amount = amount;
    }

    @Override
    public void publicInformationAboutCondition() {
        System.out.println("\nConditions for individuals.\n" +
                "Replenishment and debiting occurs without commission.\n" +
                "Your account balance = " + getAmount() + "\n");
    }
}
