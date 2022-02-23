package Bank;

import java.util.Calendar;

public class DepositAccount extends BankAccount {

    private Calendar lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = Calendar.getInstance();
        lastIncome.add(Calendar.MONTH, 1);
    }

    @Override
    public boolean take(double amountToTake) {
        Calendar calendarNow = Calendar.getInstance();

        if (calendarNow.after(lastIncome)) {
            super.take(amountToTake);
            return true;
        } else {
            System.out.println("Money cannot be withdrawn from the deposit account yet, as a month has not passed.");
            return false;
        }

    }
}
