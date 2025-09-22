package BankSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Bank {

    private BankAccount account; //object for sign up, log in

    //create file
    private static final String accountFile = "data/accounts.txt";


    //getter for file
    public static String getAccountFile() {
        return accountFile;
    }

    //getter
    public BankAccount getAccount(){
        return account;
    }

    //sign up method
    public void signUp(Scanner scanner) throws FileNotFoundException {

        System.out.print("Please enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("Please set the PIN (4 digits): ");
        int pin = scanner.nextInt();
        System.out.println();

        System.out.print("Please deposit an initial balance: ");
        double initBalance = scanner.nextDouble();
        System.out.println();

        System.out.println("Generating your account number...");
        System.out.println("Your account has been successfully created!");
        System.out.println();

        System.out.println("Account Details:");
        System.out.println("-----------------");

        System.out.println("Name: " + name);

        //generating random account number
        Random random = new Random();
        int randomAccNum = random.nextInt(90000000) + 10000000; //random 8 digits between 1 and 9

        System.out.println("Account Number: " + randomAccNum);
        System.out.println("PIN: " + pin);
        System.out.println("Initial balance: " + "$" + initBalance);
        System.out.println();

        System.out.println("You can now log in using your account number and PIN.");

//        BankAccount account = new BankAccount(randomAccNum, pin);
        this.account = new BankAccount(randomAccNum, pin, name, initBalance);


        //save(write)data entered by the user to the file
        PrintWriter printWriter = new PrintWriter(accountFile);
        printWriter.printf("%s,%d,%d,%.2f,%n", account.getName(), account.getAccountNumber(), account.getPin(), account.getBalance());
        printWriter.close();
    }

    public void logIn(Scanner scanner) throws FileNotFoundException {

        //read the data from the file
        File file = new File(accountFile); //open file, read, rebuild obj

        if (file.exists()) {
            Scanner scanner1 = new Scanner(file); //open file

            if (scanner1.hasNextLine()) {
                String readLine = scanner1.nextLine(); //read line by line
                String[] parts = readLine.split(","); //split to convert the types

                //convert the types
                String name = parts[0];
                int accNum = Integer.parseInt(parts[1]);
                int pin = Integer.parseInt(parts[2]);
                double balance = Double.parseDouble(parts[3]);

                //re-create the obj to store data
                this.account = new BankAccount(name, accNum, pin, balance);

            }

            scanner1.close();
        }

        System.out.print("Please enter your bank account number: ");
        int accNum = scanner.nextInt();

        System.out.println();

        //attempts allowed for PIN
        int maxAttempts = 3;

        while (maxAttempts > 0) {

            if (accNum == account.getAccountNumber()) { //load data from file

                System.out.print("Please enter your PIN: ");
                int accPin = scanner.nextInt();
                System.out.println();

                if (accPin == account.getPin()) {
                    System.out.println("Login successful. Welcome to the bank " + account.getName());
                    break; //out of loop if pin is correct
                } else {
                    System.out.println("Wrong PIN.");
                    maxAttempts--; //decrement the max attempts
                    System.out.println("You have " + maxAttempts + " attempt(s) left.");

                }

            } else {
                System.out.println("Account not found. Please enter the correct account number.");
               System.exit(1); //exit the program
            }
        }


        if (maxAttempts == 0) {
            System.out.println("You've run out of Attempts. Account locked. Please contact the bank.");
        }


    }

    //view account details
    public void viewAcc() {
        System.out.println("Account Holder: " + account.getName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("PIN: " + account.getPin());
        System.out.println("Balance: " + "$" + account.getBalance());

    }

    //method for reading balance from the file
    public double showBalance(){
        System.out.println("Total Balance: " + "$" + account.getBalance());
        return  account.getBalance();
    }




}
