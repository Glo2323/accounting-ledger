package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AccountLedgerApp {


    public static void main(String[] args) {

        //?Creating my scanner
        Scanner input = new Scanner(System.in);

        displayHomeMenu(input);


    }


    //!Creating  the menu to ask questions
    public static void displayHomeMenu(Scanner sC) {

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {

        System.out.println("HomeScreen?\n");

        System.out.println(" 1 - Add Deposit\n");

        System.out.println(" 2 - Make Payment\n");

        System.out.println(" 3 - Ledger\n");

        System.out.println(" 4 - Exit\n");

        System.out.println("Enter your command: ");

        //*Catch users input
        int command = sC.nextInt();

        //*Catch next line
        sC.nextLine();

            //*Navigating through the menu
            switch (command) {
                case 1 -> addDeposit(sC);
                case 2 -> makePayment(sC);
                case 3 -> displayLedgerScreen(sC);
                case 4 -> menuApp = false;


            }

        }




    }

    //!Creating a method for depositing
    public static void  addDeposit(Scanner sC) {

        //?Creating a try to catch any unexpected errors
        try {

            //*Setting up dates
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            //*Creating buffer writer to write their deposit in the file
            BufferedWriter bankWriter = new BufferedWriter(new FileWriter("transaction.csv", true));

            //*Asking for how much there deposit
            System.out.println("How much would you like to deposit $");

            //*Catching there answer
            String deposit = sC.nextLine();

            //*Asking for a vendor
            System.out.println("Vendor: ");

            //*Catching the answer
            String vendor = sC.nextLine();

            //*Asking for a description
            System.out.println("Small description: ");

            //*Catching the answer
            String description = sC.nextLine();


            //*Formatting there deposit into the file
            String writtenLine = String.format("%s|%.5s|Deposit|%s|%s|%s\n",date, time, vendor, description, deposit );

            //*Writing the transaction onto the file
            bankWriter.write(writtenLine);

            bankWriter.close();




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //!Creating a method for depositing
    public static void  makePayment(Scanner sC) {

        //?Creating a try to catch any unexpected errors
        try {

            //*Setting up dates
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            //*Creating buffer writer to write their deposit in the file
            BufferedWriter bankWriter = new BufferedWriter(new FileWriter("transaction.csv", true));

            //*Asking for how much there deposit
            System.out.println("How much would you like to Pay  $");

            //*Catching there answer
            String deposit = sC.nextLine();

            //*Asking for a vendor
            System.out.println("Vendor: ");

            //*Catching the answer
            String vendor = sC.nextLine();

            //*Asking for a description
            System.out.println("Small description: ");

            //*Catching the answer
            String description = sC.nextLine();

            //*Formatting there deposit into the file
            String writtenLine = String.format("%s|%.5s|Payment|%s|%s|-%s\n",date, time, vendor, description, deposit );

            //*Writing the transaction onto the file
            bankWriter.write(writtenLine);

            bankWriter.close();




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //!Creating the ledger
    public static void displayLedgerScreen(Scanner sC){

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {

            System.out.println("LedgerScreen?\n");

            System.out.println(" 1 - All\n");

            System.out.println(" 2 - Deposit only\n");

            System.out.println(" 3 - Payments only\n");

            System.out.println(" 4 - Reports\n");

            System.out.println(" 5 - Home");

            System.out.println("Enter your command: ");

            //*Catch users input
            int command = sC.nextInt();

            //*Catch next line
            sC.nextLine();

            //*Navigating through the menu
            switch (command) {
                case 1 -> allTransactions();
                case 2 -> makePayment(sC);
                case 3 -> displayLedgerScreen(sC);
                case 5 -> menuApp = false;


            }

        }



    }

    //!Creating print all transaction method
    public static void allTransactions(){

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
            String transaction;
            while ((transaction = bankReader.readLine()) != null){

                //* Placing the info into a list
                String[] transactionInfo = transaction.split("\\|");

                //*Assigning the info into there parts
                LocalDate date = LocalDate.parse(transactionInfo[0]);
                LocalTime time = LocalTime.parse(transactionInfo[1]);
                String type = transactionInfo[2];
                String vendor = transactionInfo[3];
                String description = transactionInfo[4];
                double amount = Double.parseDouble(transactionInfo[5]);

                //!Creating the transaction
                Transaction demo = new Transaction(date, time, type, vendor, description, amount);

                //*Display transaction info
                System.out.println("Transaction");
                System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n", date, time,type, vendor, description, amount);

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }


}

