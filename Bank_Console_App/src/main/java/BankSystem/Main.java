//Version - 1.0 -  29.08.2025
//Version - 2.0 -  03.09.2025
//Version - 3.0 -  08.09.2025
//Version - 4.0 -  10.09.2025
package BankSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        Scanner scanner = new Scanner(System.in); //for user choice
        Bank bank = new Bank(); //for sign up, log in
        BankAccount account = null; //init the variable first (empty container)

        System.out.println();

        //logic for user ID and PIN


        int input = 0;
        while(input !=3) {
            //login
            System.out.println("Welcome to the Bank!");
            System.out.println();
            System.out.println("1. Sign Up\n2. Log in\n3. Exit");
            System.out.println();

            System.out.print("Please enter your choice: ");
             input = scanner.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    bank.signUp(scanner); //sign up method from bank class
                    break;
                case 2:
                    bank.logIn(scanner); //log in method from bank class
                    account = bank.getAccount(); //get the logged-in account
                    break;
                case 3:
                    System.out.println("Thank you for using our service.");
                    break;
                default:
                    System.out.println("Invalid Input. Please try again.");
                    break;

            }
            System.out.println();
            //logic for bank operation
            int choice = 0;

            if(input == 2){
                while(choice !=5) {

                    System.out.println();

                    System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.View Account Details\n5.Log out");
                    System.out.println();
                    System.out.print("Please choose an option: ");
                    choice = scanner.nextInt();

                    System.out.println();

                    switch (choice) {
                        case 1:
                            account.deposit(scanner);
                            break;
                        case 2:
                            account.withdraw(scanner);
                            break;
                        case 3:
                            bank.showBalance();
                            break;
                        case 4:
                            bank.viewAcc();
                            break;
                        case 5:
                            break; //go back to main menu
                        default:
                            System.out.println("Invalid Input. Please try again.");
                    }
                }
            }
        }

        scanner.close();

    }
}
