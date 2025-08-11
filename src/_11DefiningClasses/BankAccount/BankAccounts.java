package _11DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {

    private static int idCnt = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public BankAccount() {

        this.id = idCnt++;
        this.balance = 0.0;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] data = input.split(" ");
            String cmd = data[0];

            switch (cmd) {

                case "Create":

                    BankAccount account = new BankAccount();
                    accountsMap.put(account.getId(), account);

                    System.out.println("Account ID" + account.getId() + " created");
                    break;

                case "Deposit":

                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);

                    if (accountsMap.containsKey(id)) {

                        accountsMap.get(id).deposit(amount);
                        System.out.println("Deposited " + (int) amount + " to ID" + id);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":

                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;

                case "GetInterest":

                    id = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);

                    if (accountsMap.containsKey(id)) {
                        double interestAmount = accountsMap.get(id).getInterest(years);

                        System.out.printf("%.2f%n", interestAmount);
                    }
                    else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}
