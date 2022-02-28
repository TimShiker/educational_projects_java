package Transactions;

import Transactions.core.Account;
import Transactions.core.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        HashMap<String, Account> accountGen = new HashMap<>();

        for(int i = 0; i < 500; i++){
            Account account = generateAccount();
            accountGen.put(account.getAccNumber(), account);
        }

        Bank bank = new Bank(accountGen);
        System.out.println(bank.getGeneralBalance() + " баланс до транзакций");

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 7; i++){
           threads.add(new Thread(bank));
        }

        threads.forEach(Thread::start);
    }

    public static Account generateAccount() {

        Random randomForAccNumber = new Random();
        Random randomForMoney = new Random();
        int maxSumMoney = 500_000;

        StringBuilder card = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num = randomForAccNumber.nextInt(10);
            card.append(num);
        }

        long sum = randomForMoney.nextInt(maxSumMoney);

        return new Account(card.toString(), sum);
    }


}