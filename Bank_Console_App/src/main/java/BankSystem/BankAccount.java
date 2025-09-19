package BankSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankAccount {

    private String name;
    private int accountNumber; //to store random acc num
    private int pin; //to store the user defined pin
    private double balance;  //store balance in file


    //constructor for sign up
    public BankAccount(int accountNumber, int pin, String name, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;

    }

    //constructor for log in, view Acc
    public BankAccount(String name, int accNum, int pin, double balance) {
        this.name = name;
        this.accountNumber = accNum;
        this.pin = pin;
        this.balance = balance;
    }

    //constructor for bank operation
    public BankAccount() {

    }


    //getters
    public String getName(){
        return name;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int getPin(){
        return pin;
    }



    //setters

    public void setName(String name){
        this.name = name;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    //method
    public double deposit(Scanner scanner) throws FileNotFoundException { //update balance from file + deposit amount

        //ask the user for input
        System.out.println("How much do you want to deposit?");
        System.out.println();
        System.out.print("Add Deposit Amount: ");
        double addDeposit = scanner.nextDouble();

        //read balance from the file first
        File file = new File(Bank.getAccountFile());

        if(file.exists()){
            Scanner scanner1 = new Scanner(file);
            if(scanner1.hasNextLine()){
                String readLine = scanner1.nextLine();
                String[] parts = readLine.split(",");

                //update fields from file
                name = parts[0];
                accountNumber = Integer.parseInt(parts[1]);
                pin = Integer.parseInt(parts[2]);
                balance = Double.parseDouble(parts[3]);

            }

            scanner1.close(); //close the file scanner
        }

        balance = balance + addDeposit;

       //write the balance to the file
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.printf("%s,%d,%d,%.2f,%n",this.name, this.accountNumber, this.pin, this.balance);
        printWriter.close();

        System.out.println("Deposit: " + "$"+ addDeposit);

        System.out.println("Total Balance: " + "$"+ this.balance);

        return this.balance; //amount entered by the user + balance from file
    }

    public double withdraw(Scanner scanner) throws FileNotFoundException { //update balance from file - withdrawal amount

        //ask the user
        System.out.println("How much do you want to withdraw?");
        System.out.println();
        System.out.print("Add Withdrawal Amount: ");
        double addWithdraw = scanner.nextDouble();

        //read balance from file
        File file = new File(Bank.getAccountFile());

        if(file.exists()){
            Scanner scanner1 = new Scanner(file);
            if(scanner1.hasNextLine()){
                String readLine = scanner1.nextLine();
                String[] parts = readLine.split(",");

                //update fields from the file
                name = parts[0];
                accountNumber = Integer.parseInt(parts[1]);
                pin = Integer.parseInt(parts[2]);
                balance = Double.parseDouble(parts[3]);
            }
            scanner1.close();
        }



        //withdrawal logic
        if (addWithdraw <= balance) {

            balance = balance - addWithdraw;

            //write(save) the data back to the file
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.printf("%s,%d,%d,%.2f,%n",this.name, this.accountNumber, this.pin, this.balance);
            printWriter.close();

            System.out.println("Withdrawal: " + "$" + addWithdraw);
            System.out.println("Total Balance: " + "$" + balance);
        } else {
            System.out.println("Insufficient Funds.");
        }

        return balance; //amount entered by the user + balance from file
    }


        public double getBalance(){
            return this.balance;
    }

}
