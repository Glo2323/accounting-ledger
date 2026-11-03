package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Collections.copy;
import static java.util.Collections.sort;

public class AccountLedgerApp {


    public static void main(String[] args) {

        //?Creating my scanner
        Scanner input = new Scanner(System.in);

        //?Calling the Menu
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
                case 2 -> onlyDeposits();
                case 3 -> onlyPayments();
                case 4 -> displayReportsMenu(sC);
                case 5 -> menuApp = false;


            }

        }



    }

    //!Creating print all transaction method
    public static void allTransactions(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());



            }
            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
            //*Display transaction info
            System.out.println("Transaction");
            System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                    demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                    demo.getDescription(), demo.getAmount());
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    //!Creating a method to print only deposits
    public static void onlyDeposits(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());



            }
            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
                //*Display transaction info
                System.out.println("Transaction");
                System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                        demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                        demo.getDescription(), demo.getAmount());
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method to print only payments
    public static void onlyPayments(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());



            }
            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
                //*Display transaction info
                System.out.println("Transaction");
                System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                        demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                        demo.getDescription(), demo.getAmount());
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method to display the reports menu
    public static void displayReportsMenu(Scanner sC){

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {

            System.out.println("ReportsScreen\n");

            System.out.println(" 1 - Month to date\n");

            System.out.println(" 2 - Previous Month\n");

            System.out.println(" 3 - Year to Date\n");

            System.out.println(" 4 - Previous Year\n");

            System.out.println(" 5 - Search by Vendor\n");

            System.out.println(" 6 - Custom Search\n");

            System.out.println(" 0 - Back");

            System.out.println("Enter your command: ");

            //*Catch users input
            int command = sC.nextInt();

            //*Catch next line
            sC.nextLine();

            //*Navigating through the menu
            switch (command) {
                case 0 -> menuApp = false;
                case 1 -> monthToDate();
                case 2 -> previousMonth();
                case 3 -> yearToDate();
                case 4 -> previousYear();
                case 5  -> searchByVendor(sC);
                case 6  -> customSearch(sC);


            }

        }

    }

    //!Creating a method that shows month to date Transactions
    public  static void monthToDate(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());

            }
            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*If statement  to only print out equal statement
                if (LocalDate.now().getMonth() == demo.getDate().getMonth() &&
                        LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method that shows previous month Transaction
    public  static void previousMonth(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());

            }
            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //?Setting up my month placement
                LocalDate lastMonth = LocalDate.now().minusMonths(1);
                //*If statement  to only print out equal statement
                if (demo.getDate().getMonth() == lastMonth.getMonth() &&
                        LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    //!Creating a method that shows Year to date Transaction
    public static void yearToDate(){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());

            }
            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*If statement  to only print out equal statement
                if (LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that shows previous year Transaction
    public static void previousYear(){

        ArrayList<Transaction> transactionsList = new ArrayList<>();

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());


            }
            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*Setting up last year placement
                LocalDate lastYear = LocalDate.now().minusYears(1);
                //*If statement  to only print out equal statement
                if (demo.getDate().getYear() == lastYear.getYear()) {

                    //*Display transaction info
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that can search by vendor
    public static void searchByVendor(Scanner scanner){
        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //*Asking question
            System.out.println("What is the vendor name:");
            String vendorName = scanner.next();

            //?Loop over the list to find all matching names
            String transaction;
            while ((transaction = bankReader.readLine()) != null) {

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());



            }
            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {

                if (vendorName.equalsIgnoreCase(demo.getVendor())) {
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();
        }
        catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that can filter search
    public static void customSearch(Scanner scanner){

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop over the list to find all matching names
            String transaction;
            while ((transaction = bankReader.readLine()) != null) {

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
                transactionsList.add(demo);
                //?Sorting the transaction from newest to oldest
                transactionsList.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime)
                        .thenComparing(Transaction::getDescription).reversed());

            }
            //*Prompting the user for questions to create the filter
            //*Asking for a start date
            System.out.println("What's the Start date Ex(2025-6-20)\n" +
                    " Press Enter to Skip:" );
                //*Catching the answer
                String start = scanner.nextLine().trim();
                //*parsing the date if they enter a date
                LocalDate startDate = start.isEmpty() ? null : LocalDate.parse(start);

            //*Asking for a end date
            System.out.println("What's the End date Ex(2025-6-20)\n" +
                    " Press Enter to Skip:" );
            //*Catching the answer
            String end = scanner.nextLine().trim();
            //*parsing the date if they enter a date
            LocalDate endDate = end.isEmpty() ? null : LocalDate.parse(end);

            //*Asking for a type
            System.out.println("What's the Type\n" +
                    " Press Enter to Skip:" );
            //*Catching the answer
            String type = scanner.nextLine().trim();

            //*Asking for a vendor
            System.out.println("What's the Vendor\n" +
                    "Press Enter to Skip:" );
            //*Catching the answer
            String vendor = scanner.nextLine().trim();
            //*Asking for a descri
            System.out.println("What's the Description\n" +
                    "Press Enter to Skip:" );

            String description = scanner.nextLine().trim();

            System.out.println("What's the amount\n" +
                    "Press Enter 0 to Skip:" );

            double amount = scanner.nextDouble();


            for (Transaction demo : transactionsList) {



                if ( startDate == null) {

                }
                else if  (demo.getDate().isAfter(startDate) && demo.getDate().isBefore(endDate)) {
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }
                if (endDate == null) {

                }


                if (type.equalsIgnoreCase("null")) {

                }
                else if (demo.getType().equalsIgnoreCase(type)){
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }


                if (vendor.equalsIgnoreCase("null")) {

                }
                else if (demo.getVendor().equalsIgnoreCase(vendor)){
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }


                if (description.equalsIgnoreCase("null")) {

                }
                else if (demo.getDescription().equalsIgnoreCase(description)){
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }


                if(amount == 0){

                }
                else  if (demo.getAmount() == amount){
                    System.out.println("Transaction");
                    System.out.printf("%s | %s | %s | %s | %s | %.2f |\n\n",
                            demo.getDate(), demo.getTime(), demo.getType(), demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }

            }


        }
        catch (Exception e){

            System.out.println("Error" + e.getMessage());

        }

    }




}

