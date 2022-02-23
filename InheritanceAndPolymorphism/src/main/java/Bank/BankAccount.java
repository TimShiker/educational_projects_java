package Bank;

public class BankAccount {

    private double amountBank;

    public double getAmountBank() {
        return amountBank;
    }

    public void put(double amountToPut) {

        if (amountToPut > 0) {
            amountBank = amountBank + amountToPut;
        } else System.out.println("The amount to be replenished must be greater 0.");
    }

    public boolean take(double amountToTake) {

        if (amountToTake > amountBank) {
            System.out.println("The amount to withdraw from the account must " +
                    "be less than or equal to the amount on the account.");
            return false;
        } else {
            amountBank = amountBank - amountToTake;
            return true;
        }
    }

    public boolean send(BankAccount receiver, double amount) {

        if (take(amount)) {

            double amountBeforePut = receiver.getAmountBank();
            receiver.put(amount);
            if(receiver.getAmountBank() - amount == amountBeforePut){
                return true;
            }
            else {
                System.out.println("An error occurred during translation. Money returned to bank account.");
                put(amount);
                return false;
            }
        } else {
            System.out.println("The amount to transfer from a bank account to another account must " +
                    "be less than or equal to the amount in the bank account.");
            return false;
        }
    }

}
