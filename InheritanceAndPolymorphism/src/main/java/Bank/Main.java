package Bank;

public class Main {

    public static void main(String[] args) {


        BankAccount bankAccount = new BankAccount();

        bankAccount.put(50000);


        System.out.println("Amount bank before " + bankAccount.getAmountBank());

        CardAccount cardAccount = new CardAccount();

        System.out.println("Amount card before " + cardAccount.getAmountBank());

        bankAccount.send(cardAccount, 10000);

        System.out.println("Amount bank after " + bankAccount.getAmountBank());
        System.out.println("Amount bank after " + cardAccount.getAmountBank());

    }
}
