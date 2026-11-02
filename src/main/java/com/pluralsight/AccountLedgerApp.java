package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class AccountLedgerApp {


    public static void main(String[] args) {

        //?Creating my scanner
        Scanner input = new Scanner(System.in);


        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {
            int command = displayHomeMenu(input);

            input.nextLine();


            //*Navigating through the menu
            switch (command) {
                case 1 -> addDeposit(input);
//                case 2 -> ;
                case 4 -> menuApp = false;


            }

        }

    }


    //!Creating  the menu to ask questions
    public static int displayHomeMenu(Scanner sC) {


        System.out.println("HomeScreen?\n");

        System.out.println(" 1 - Add Deposit\n");

        System.out.println(" 2 - Make Payment\n");

        System.out.println(" 3 - Ledger\n");

        System.out.println(" 4 - Exit\n");

        System.out.println("Enter your command: ");


        //*To catch our command
        return sC.nextInt();
    }

    //!Creating a method for depositing
    public static void  addDeposit(Scanner sC) {

        //?Creating a try to catch any unexpected errors
        try {

            //*Setting up dates
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            //*Creating buffer writer to write their deposit in the file
            BufferedWriter bankWriter = new BufferedWriter(new FileWriter("transaction.csv"));

            //*Asking for how much there deposit
            System.out.println("How much would you like to deposit $");

            //*Catching there answer
            String deposit = sC.nextLine();

            //*Asking for a description
            System.out.println("Small description: ");

            //*Catching the answer
            String description = sC.nextLine();

            //*Formatting there deposit into the file
            String writtenLine = String.format("%s|%.5s|Deposit|%s|%s",date, time, description, deposit );

            //*Writing the transaction onto the file
            bankWriter.write(writtenLine);

            bankWriter.close();




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
