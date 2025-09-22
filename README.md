Bank-Console-App

CLI Bank Program
-------------------

This is a simple (CLI) banking program written in Java. It simulates basic banking features like account creation, login, deposits, withdrawals, and balance checking. I built it to practice object-oriented programming(OOP), file I/O, and thinking about how real-world systems manage user accounts.


Features
-----------

Main Menu: Login, Sign Up, Exit

Sign Up: Enter name, create PIN, make an initial deposit. A random account number is generated and stored in a '.txt' file.

Login: Enter account number and PIN. User gets 3 attempts before account lock and exit. Data is verified against stored '.txt' records.

After Login Menu:

- Deposit money

- Withdraw money

- Check balance

- View account info

- Logout (return to main menu)


Data Storage
---------------

- Account info (name, PIN, account number, balance) is stored in a `.txt` file.

- Balance updates persist between program runs, so the latest account data is always saved.



My Thinking
------------

I designed this project to mimic how a real bank system works on a small scale:


Security: PIN and account number verification with limited attempts.

Persistence: File I/O ensures data isn’t lost after closing the program.

Scalability: Modular design with OOP principles, making it easier to add features later.



Example Run
----------------


Welcome to the Bank!



1. Sign Up

2. Log in

3. Exit



Please enter your choice: 1



Please enter your name: Sai Sai



Please set the PIN (4 digits): 1234



Please deposit an initial balance: 600



Generating your account number...

Your account has been successfully created!



Account Details:
-----------------

Name: Sai Sai

Account Number: 99649198

PIN: 1234

Initial balance: $600.0



You can now log in using your account number and PIN.



Welcome to the Bank!



1. Sign Up

2. Log in

3. Exit



Please enter your choice: 2



Please enter your bank account number: 99649198



Please enter your PIN: 1234



Login successful. Welcome to the bank Sai Sai



1.Deposit

2.Withdraw

3.Check Balance

4.View Account Details

5.Log out



Please enter your choice:


-----------------------------

You can do the bank operation until you choose to log out and exit the program.

---------------------

Project Structure
-------------------

Bank Console App/
│ 
│ 			├─ src/

│   		└─ main/

│       	└─ java/

│           └─ BankSystem/

│               ├─ Bank.java

│               ├─ BankAccount.java

│               └─ Main.java

└─ data/

   └─ accounts.txt

---------------------------------------------


How to Run
------------

Prerequisites

Java 24 (JDK 24) installed on your system.

Eclipse Temurin or Oracle JDK is fine.

IntelliJ IDEA (optional, for running inside IDE).

Git (optional, for cloning the repository).

1️⃣ Running in IntelliJ IDEA

Clone the repository and open the project in IntelliJ:

git clone https://github.com/yourusername/Bank-Console-App.git


Make sure the Project SDK is set to Java 24:

File → Project Structure → Project → Project SDK → Select JDK 24

Make sure the working directory is the project root:

Run → Edit Configurations → Working directory → Bank_Console_App/

Open Main.java and click Run.

The program will run in the IntelliJ console.

2️⃣ Running in Windows CMD or MacOS Terminal 

Open CMD or Terminal and navigate to the project root:

cd path\to\Bank_Console_App


Compile the Java files into an output folder:

javac -d out src\main\java\BankSystem\*.java



Run the program:

java -cp out BankSystem.Main


Purpose
------------

This project helped me practice Java OOP, file I/O, and building a real-world style login system. In the current version, only single account is supported. 

In the future, I plan to extend it to support multiple accounts and transaction history.

