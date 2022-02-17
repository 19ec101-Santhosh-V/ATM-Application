package ATM;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class atm {
    static Scanner sc = new Scanner(System.in);
    static String username = "";
    static int password = 0;
    static int balance = 0;
    static String name = "Santhosh";
    static String pin = "3333";
    static int amount[] = {100, 200, 500, 2000};
    static int balanceamount = 28000;
    static int den[] = {10, 10, 10, 10};
    static int s = 0;
    static int lastamount;
    static int c = 0, p1, p2, p3, pass,h,h1,h2,h3,h4;
    static int a1=0,a2=0,a3=0;
    static int usr1,usr2,usr3,usr4;
    static int m,m1;
    static int withdraw,Withdraw1,deposit;

    public static void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    static void admin() {
        System.out.println("Welcome Admin");
        System.out.println("Enter the username:");
        username = sc.nextLine();
        System.out.println("Pin Number:");
        password = sc.nextInt();
        if (username.equals("Santhosh") && pin == "3333") {
            checking();
        } else {
            System.out.println("Invalid Username or password...Retry again");

        }
    }

    public static void checking() {
        System.out.println("1.Balance Enquiry: ");
        System.out.println("2.Load the amount :");
        int load = sc.nextInt();
        if (load == 1) {
            System.out.println("No of notes in 100----> " + den[0]);
            System.out.println("No of notes in 200----> " + den[1]);
            System.out.println("No of notes in 500---->" + den[2]);
            System.out.println("No of notes in 2000---->" + den[3]);
            int bal = den[0] * amount[0] + den[1] * amount[1] + den[2] * amount[2] + den[3] * amount[3];
            System.out.println("Balance = " + bal);
            System.out.println("Press 1 then enter to continue");;
            h1=sc.nextInt();
            if(h1==1){
                admin();
            }
        }
        if (load == 2) {
            System.out.println("Enter the no.of.note in 100 rupees");
            den[0] += sc.nextInt();
            System.out.println("Enter the no.of.note in 200 rupees");
            den[1] += sc.nextInt();
            System.out.println("Enter the no.of.note in 500 rupees");
            den[2] += sc.nextInt();
            System.out.println("Enter the no.of.note in 2000 rupees");
            den[3] += sc.nextInt();
            int den0 = den[0] * 100;
            int den1 = den[1] * 200;
            int den2 = den[2] * 500;
            int den3 = den[3] * 2000;
            int den = den0 + den1 + den2 + den3;
            System.out.println(" amount added");

            delay(2000);
        }
    }

    static void user() {
        System.out.println("Welcome ..........");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Pin Change");
        System.out.println("4.Money Transfer");
        System.out.println("5.Balance");
        System.out.println("6.Exit");
        c = sc.nextInt();
        if (c == 1) {
            withdraw();
        } else if (c == 5) {
            balance();
        } else if (c == 2) {
            deposit();
        } else if (c == 3) {
            pinchange();
        } else if (c == 6) {

        }
    }

    static void withdraw() {
        System.out.print("Enter money to be withdraw:");
        int two_thousand=0,five_hundred=0,two_hundred=0,one_hundred=0;
        int   withamount = sc.nextInt();
        if(balanceamount>= withdraw)
        {
            while(withamount>0){
                if(withamount>=2000 && den[3]!=0){
                    two_thousand++;

                    den[3]--;
                    withamount=withamount-2000;
                }else if(withamount>=500 && den[2]!=0){
                    five_hundred++;

                    den[2]--;
                    withamount=withamount-500;
                }else if(withamount>=200 && den[1]!=0){
                    two_hundred++;

                    den[1]--;
                    withamount=withamount-200;
                }else if(withamount>=100 && den[0]!=0){
                    one_hundred++;

                    den[0]--;
                    withamount=withamount-100;
                }
            }
            System.out.println("2000 notes :"+two_thousand);
            System.out.println("500 notes  :"+five_hundred);
            System.out.println("200 notes  :"+two_hundred);
            System.out.println("100 notes  :"+one_hundred);
            System.out.println("\tThanks for visiting");
            balanceamount = balanceamount - withdraw;
            System.out.println("Please collect your money");
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
        System.out.println("Press 1 to continue....");
        a2 = sc.nextInt();
        if (a2 == 1) {
            user();
        }
    }

    static void balance() {
        System.out.println("your current balance is rupees: " + balanceamount);
        System.out.println("Press 4 to continue...");
        a3 = sc.nextInt();

        if(a3==4){
            user();
        }
    }
    static void deposit() {
        System.out.println("Enter the no.of 100 Rupees: ");
        usr1=sc.nextInt();
        System.out.println("Enter the no.of 200 rupees: ");
        usr2=sc.nextInt();
        System.out.println("Enter the no.of 500 Rupees: ");
        usr3=sc.nextInt();
        System.out.println("Enter the no.of 2000 Rupees: ");
        usr4=sc.nextInt();
        den[0] += usr1;
        den[1] +=usr2;
        den[2] += usr3;
        den[3] += usr4;
        m = (usr1 * 100) + (usr2 * 200) + (usr3 * 500) + (usr4 * 2000);
        balanceamount = balanceamount + m;
        System.out.println("Your Money has been successfully depsited");
        System.out.println("");
        System.out.println("Press 1 then enter to continue");
        h=sc.nextInt();
        if(h==1){
            user();
        }

    }
    static void pinchange() {
        System.out.println("Enter the old password :");
        p1 = sc.nextInt();
        if (p1 == password) {
            System.out.println("Enter the new Password : ");
            p2 = sc.nextInt();
            System.out.println("confirm Password :");
            p3 = sc.nextInt();
            if (p2 == p3) {
                pass = p3;
                System.out.println("Your pin changed succussfully");
                System.out.println("Press 1 to continue...");
                a1=sc.nextInt();
                if(a1==1)
                    user();

            }
        }
        else{
            System.out.println("Invalid password");
        }
    }

    public static void main(String args[]){
        do {
            System.out.println("Welcome to this ATM");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.exit");
            System.out.print(" Enter your choice :");
            s = sc.nextInt();
            sc.nextLine();
            switch (s) {
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;

                case 3:
                    System.out.println("Exit successfully");
                    break;
                default:
            }
        } while (s != 3);
        if (s > 3)
            System.out.println("Invalid input");
    }

}
