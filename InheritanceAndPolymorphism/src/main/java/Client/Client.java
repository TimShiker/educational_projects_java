package Client;

public abstract class Client {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {

        if (amountToPut > 0) {
            amount = amount + amountToPut;
        } else {
            System.out.println("Error. The amount to be replenished must be greater 0.");
        }
    }

    public void take(double amountToTake) {

        if (amountToTake > amount) {
            System.out.println("Error. The amount to withdraw from the account must be less than " +
                    "or equal to the amount on the account.");
        } else {
            amount = amount - amountToTake;
        }
    }

    public abstract void publicInformationAboutCondition();
}
