package Bank;

public class CardAccount extends BankAccount {

    private final double commissionPercentage = 1;

    @Override
    public boolean take(double amountToTake) {
        return super.take(amountToTake + getCommission(amountToTake));
    }

    private double getCommission(double amountToTake){
        return amountToTake * commissionPercentage / 100;
    }

}
