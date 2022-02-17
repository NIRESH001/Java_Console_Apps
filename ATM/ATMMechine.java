import java.util.*;

public class ATMMechine {
    static int[] cash = { 2000, 500, 200, 100 };
    static int[] avalible = { 10, 10, 10, 10 };
    static int total = 0;
    static Scanner sc = new Scanner(System.in);
    static {
        for (int i = 0; i < cash.length; i++) {
            total += cash[i] * avalible[i];
        }
    }

    void add() {
        System.out.println("----you can fill the amount----");
        for (int i = 0; i < cash.length; i++) {
            System.out.println("no of " + cash[i]);
            avalible[i] += sc.nextInt();
            System.out.println("total no of " + cash[i] + " notes are avalible ->" + avalible[i]);
        }
        System.out.println("$$$$$$-Money added successfully-$$$$$$");
        Admin.adminpage();

    }

    void ShowBalence() {
        System.out.println("++++Show Balance++++");
        for (int i = 0; i < cash.length; i++) {
            System.out.println(cash[i] + " -> " + avalible[i]);
        }
        System.out.println("total amount in you ATM machine :" + total);
        Admin.adminpage();
    }

    static void withdraw(int i) {
        System.out.print("Enter Amount : ");
        int amt = sc.nextInt();
        if (User.useramount[i] >= amt && amt % 100 == 0 && total >= amt) {
            User.useramount[i] -= amt;
            while (amt != 0) {
                if (amt >= 2000) {
                    avalible[0] -= 1;
                    amt -= 2000;
                } else if (amt >= 500) {
                    avalible[1] -= 1;
                    amt -= 500;
                } else if (amt >= 200) {
                    avalible[2] -= 1;
                    amt -= 200;
                } else if (amt >= 100) {
                    avalible[3] -= 1;
                    amt -= 100;
                }
            }
            if (amt == 0) {
                System.out.println("Withdraw Success");
            }
        } else {
            System.out.println("Cannot be withdrawn");
        }
    }

    static void deposite(int i) {
        System.out.println("enter amount :");
        int amount = sc.nextInt();
        User.useramount[i] += amount;
        total += amount;
        System.out.print("Enter 2000 Rs. Notes :");
        avalible[0] += sc.nextInt();
        System.out.print("Enter 500 Rs. Notes :");
        avalible[1] += sc.nextInt();
        System.out.print("Enter 200 Rs. Notes :");
        avalible[2] += sc.nextInt();
        System.out.print("Enter 100 Rs. Notes :");
        avalible[3] += sc.nextInt();
        System.out.println("Deposit Successfully");
    }

    static void show_Balence(int useramount) {
        System.out.print("your balance : ");
        System.out.println(useramount);
    }

    public static void transfer(int i) {
        System.out.println("Enter Bank account you want to Transfer");
        String user = sc.nextLine();
        int ind = -1;
        for (int x = 0; x < User.username.length; x++) {
            if (user.equals(User.username[x])) {
                ind = x;
                break;
            }
        }
        if (ind == -1) {
            System.out.println("Receiver not available");
        } else {
            System.out.print("Enter amount to transfer : ");
            int amt = sc.nextInt();
            if (User.useramount[i] >= amt) {
                if (User.bank[i] == User.bank[ind]) {
                    User.useramount[i] -= amt;
                } else {
                    User.useramount[i] -= (amt + 100);
                }
                User.useramount[ind] += amt;
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

}
