package Transactions.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank implements Runnable {

    private volatile HashMap<String, Account> accounts;
    private final Random random = new Random();
    private final int maxTransferSum = 200_000;
    private AtomicInteger countTransfers = new AtomicInteger();

    public Bank() {
        accounts = new HashMap<>();
    }

    public Bank(HashMap<String, Account> accounts) {
        this();
        this.accounts = accounts;
    }

    private synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        System.out.println("Перед попыткой снятия " + amount + " рублей на счету было " + getBalance(fromAccountNum) +
                " руб.");

        if (amount > 50_000) {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                System.out.println("Служба безопасности банка обнаружила мошенничество в ходе попытки " +
                        "перевода суммы в размере " + amount + " руб. со счёта " + "\"" + fromAccountNum +
                        "\" на счёт " + "\"" + toAccountNum + "\". Оба счёта заблокированы.");
                blockedAccounts(fromAccountNum, toAccountNum);
            } else {
                tryTransfer(fromAccountNum, toAccountNum, amount);
            }
        } else {
            tryTransfer(fromAccountNum, toAccountNum, amount);
        }
    }

    private synchronized void tryTransfer(String fromAccountNum, String toAccountNum, long amount) {
        if (!accounts.get(fromAccountNum).isBlockAccount() &&
                !accounts.get(toAccountNum).isBlockAccount()) {
            if (accounts.get(fromAccountNum).takeMoney(amount))
                accounts.get(toAccountNum).putMoney(amount);
        } else {
            System.out.println("Перевод суммы " + amount + " руб. со счёта " + "\"" +
                    fromAccountNum + "\" на счёт " + "\"" + toAccountNum + "\" не состоялся. Причина " +
                    "указана выше.");
        }
    }

    private synchronized void blockedAccounts(String fromAccountNum, String toAccountNum) {
        accounts.get(fromAccountNum).blockAccount();
        accounts.get(toAccountNum).blockAccount();
    }

    private String[] randomAccountSearch() {

        String[] twoRandomAccount = new String[2];
        List<String> keyListAccounts = new ArrayList<>(accounts.keySet());
        Random random = new Random();

        String firstAccount = keyListAccounts.get(random.nextInt(keyListAccounts.size()));
        String secondAccount = keyListAccounts.get(random.nextInt(keyListAccounts.size()));

        while (firstAccount.equals(secondAccount)) {
            secondAccount = keyListAccounts.get(random.nextInt(keyListAccounts.size()));
        }

        twoRandomAccount[0] = firstAccount;
        twoRandomAccount[1] = secondAccount;

        return twoRandomAccount;
    }

    private long getRandomAmountTransfer() {
        Random random = new Random();
        return random.nextInt(maxTransferSum);
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getGeneralBalance() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }

    public void setAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        accounts.putAll(accounts);
    }

    public int getCountsAccounts() {
        return accounts.size();
    }

    public int getMaxTransferSum() {
        return maxTransferSum;
    }

    @Override
    public void run() {

        countTransfers.addAndGet(0);

        for (; countTransfers.get() < 100; ) {

            String[] accountsForTransfer = randomAccountSearch();

            try {
                transfer(accountsForTransfer[0], accountsForTransfer[1], getRandomAmountTransfer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countTransfers.incrementAndGet();
            System.out.println("\n");

        }
        System.out.println("Итоговый баланс в банке после всех операций " + getGeneralBalance());
    }
}
