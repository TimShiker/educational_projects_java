package Transactions.core;

public class Account
{
    private volatile long money;
    private String accNumber;
    private volatile boolean isBlockAccount;

    public Account(){
        isBlockAccount = false;
    }

    public Account(String accNumber, long money){
        this();
        this.accNumber = accNumber;
        if(money < 0){
            this.money = 0;
            System.out.println("Ошибка. Нельзя создать счёт с отрицательным балансом. " +
                    "Задана стандартная величина: по умолчанию на счёте 0 рублей.");
        }
        else {
            this.money = money;
        }
    }

    protected boolean takeMoney(long amountToTake){
        if (amountToTake > money) {
            System.out.println("Ошибка. Сумма для снятия со счёта должна быть меньше или равна сумме на счёте.");
            return false;
        }
        if(amountToTake < 0){
            System.out.println("Сумма для снятия не может быть отрицательной");
            return false;
        }
        if(isBlockAccount()) {
            System.out.println("Операцию снятия денег невозможно совершить. Счёт " + "\"" + accNumber +
                    "\" заблокирован.");
            return false;
        }

        money = money - amountToTake;
        System.out.println("Операция снятия денег прошла успешно. " +
                "Со счёта " + "\"" + accNumber + "\"" +
                " сняли " + amountToTake + " руб. Остаток на счёте = " + money + " руб.");
        return true;
    }

    protected boolean putMoney(long amountToPut){
        if(!isBlockAccount){
            money = money + amountToPut;
            System.out.println("Операция пополнения денег прошла успешно. На счёт " + "\"" + accNumber + "\"" +
                    " положили " + amountToPut + " руб. Остаток на счёте = " + money + " руб.");
            return true;
        }
        else {
            System.out.println("Операцию пополнения денег невозможно совершить. Счёт заблокирован.");
            return false;
        }
    }

    protected synchronized void blockAccount(){
        isBlockAccount = true;
    }

    protected void unBlockAccount(){
        isBlockAccount = false;
    }

    public long getMoney() {
        return money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    protected synchronized boolean isBlockAccount() {
        if(!this.isBlockAccount){
           return false;
        }
        System.out.println("Cчёт " + "\"" + accNumber + "\"" + " имеет статус заблокированного.");
        return true;
    }
}
