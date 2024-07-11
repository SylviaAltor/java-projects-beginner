/*
A simple bookkeeping OOP system with 4 choices and a loop.
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChangeSystem {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    String details = "---Money Pocket---";

    double money = 0;
    double balance = 0;
    Date date = null; // java.util.Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //format date

    String spendItem = "";

    public void mainMenu() {
        do {
            System.out.println("\n---Money Pocket Menu---");
            System.out.println("1. Details");
            System.out.println("2. Income");
            System.out.println("3. Spending");
            System.out.println("4. Exit");

            System.out.print("Please choose what you want to do (1-4): ");
            key = scanner.next();

            switch(key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.spend();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("Wrong input, please choose again");
            }
        } while(loop);
    }

    public void detail() {
        System.out.println(details);
    }

    public void income() {
        System.out.print("Income amount: ");
        money = scanner.nextDouble();
        if(money <= 0) {
            System.out.println("Income amount needs to be bigger than 0");
            return;
        }

        balance += money;
        date = new Date();
        details += "\nIncome\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void spend(){
        System.out.print("Spending: ");
        money = scanner.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("You spending range should be 0-" + balance);
            return;
        }
        System.out.print("What did you spend on: ");
        spendItem = scanner.next();
        balance -= money;
        date = new Date();
        details = "\n" + spendItem + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void exit() {
        String choice = "";
        while (true) {
            System.out.println("Are you sure you want to exit? y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }

            if (choice.equals("y")) {
                loop = false;
            }
        }
    }
}
