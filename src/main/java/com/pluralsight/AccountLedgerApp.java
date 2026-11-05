package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class AccountLedgerApp {

    public static void main(String[] args) {

        try {


            System.out.println(
                    Colors.BLUE +
                            "📜════════════ ACCOUNT LEDGER ════════════📜\n" +
                            "      AVATAR FIGURES & COLLECTIBLES\n" +
                            "📜════════════════════════════════════════📜\n"
                            + Colors.RESET
            );
            //?Creating my scanner
            Scanner input = new Scanner(System.in);

            //?Calling the Menu
            displayHomeMenu(input);
        } catch (Exception e) {

            System.out.println("error " + e.getMessage());
        }

    }


    //!Creating  the menu to ask questions
    public static void displayHomeMenu(Scanner sC) {

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {
                try {

                    Thread.sleep(500);

                    System.out.println(Colors.PURPLE +
                            "\n🎴═════════════ MAIN MENU ═══════════════════🎴4" +
                            "" +
                            Colors.RESET
                    );
                    Thread.sleep(500);
                    System.out.println(Colors.BOLD +
                            " 🟢 1️  Add Deposit" );
                    Thread.sleep(500);
                    System.out.println(Colors.BOLD +
                            " 🔴 2️  Make Payment" + Colors.RESET);
                    Thread.sleep(500);
                    System.out.println(Colors.BOLD +
                            " 📜 3️  View Ledger" + Colors.RESET);
                    Thread.sleep(500);
                    System.out.println(Colors.BOLD +
                            " 🚪 4 Exit"
                            + Colors.RESET
                    );
                    Thread.sleep(500);
                    System.out.println(
                            Colors.PURPLE +
                            "🎴══════════════════════════════════════════🎴"
                            + Colors.RESET
                    );
                    Thread.sleep(500);
                    System.out.print(
                            Colors.PURPLE +
                                    "\n➡️ Enter your command: "
                                    + Colors.RESET
                    );

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

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }

        }


    }

    //!Creating a method for depositing
    public static void addDeposit(Scanner sC) {

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
            String writtenLine = String.format("%s|%.5s|Deposit|%s|%s|%s\n", date, time, vendor, description, deposit);

            //*Writing the transaction onto the file
            bankWriter.write(writtenLine);

            bankWriter.close();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //!Creating a method for depositing
    public static void makePayment(Scanner sC) {

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
            String writtenLine = String.format("%s|%.5s|Payment|%s|%s|-%s\n", date, time, vendor, description, deposit);

            //*Writing the transaction onto the file
            bankWriter.write(writtenLine);

            bankWriter.close();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //!Creating the ledger
    public static void displayLedgerScreen(Scanner sC) {

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {
            try {

                Thread.sleep(500);
                System.out.println(
                        Colors.PURPLE +
                                "\n📜════════════ LEDGER MENU ════════════📜" +
                                Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 📂 1️  All Transactions"  + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🟢 2️  Deposits Only"  + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🔴 3️  Payments Only"  + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 📊 4️  Reports"  + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🏠 5️  Home"  + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(  Colors.PURPLE +
                        "📜════════════════════════════════════📜"
                        + Colors.RESET
                );
                Thread.sleep(500);
                System.out.print(
                        Colors.PURPLE +
                                "\n➡️ Enter your command: "
                                + Colors.RESET
                );

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
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }


    }

    //!Creating print all transaction method
    public static void allTransactions() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //*Title
            System.out.println(
                    Colors.CYAN +
                            "\n📜══════════════════════════════ All TRANSACTIONS LEDGER ═══════════════════════════════📜\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount" + Colors.RESET
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.CYAN +
                            "📜══════════════════════════════════════════════════════════════════════════════════════📜"
                            + Colors.RESET
            );

            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
                //*Display transaction info
                System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                //*Changing the color for type depending on what kinda it is
                String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                        ? Colors.GREEN + demo.getType() + Colors.RESET
                        : Colors.RED + demo.getType() + Colors.RESET;

                System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                        demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                        demo.getDescription(), demo.getAmount());
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    //!Creating a method to print only deposits
    public static void onlyDeposits() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.GREEN +
                            "\n🛍️══════════════════ AVATAR FIGURES & COLLECTIBLES DEPOSITS ════════════════════════════🛍️\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount" + Colors.RESET
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.GREEN +
                            "🛍️══════════════════════════════════════════════════════════════════════════════════════🛍️"
                            + Colors.RESET
            );

            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
                //*Display transaction info
                if (demo.getType().equalsIgnoreCase("Deposit")) {

                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method to print only payments
    public static void onlyPayments() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.RED +
                            "\n💳════════════════════════ PAYMENTS LEDGER ═════════════════════════════════════════════💳\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(
                    "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount"
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.RED +
                            "💳══════════════════════════════════════════════════════════════════════════════════════💳"
                            + Colors.RESET
            );

            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {
                //*Display transaction info
                if (demo.getType().equalsIgnoreCase("Payment")) {
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }

            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method to display the reports menu
    public static void displayReportsMenu(Scanner sC) {

        //?Loop for the menu
        boolean menuApp = true;
        while (menuApp) {
            try {

                Thread.sleep(500);
                System.out.println(
                        Colors.PURPLE +
                                "\n📊════════════ REPORTS MENU ════════════📊" +
                                Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🗓️ 1️  Month To Date" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 📅 2️  Previous Month" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🗓️ 3️  Year To Date" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 📅 4️  Previous Year" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🏪 5️  Search By Vendor" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🔍 6️  Custom Search" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(Colors.BOLD +
                        " 🏠 0️  Back" + Colors.RESET
                );
                Thread.sleep(500);
                System.out.println(
                        Colors.PURPLE +
                                "📊════════════════════════════════════📊"
                                + Colors.RESET
                );
                Thread.sleep(500);
                System.out.print(
                        Colors.PURPLE +
                                "\n➡️ Enter your command: "
                                + Colors.RESET
                );

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
                    case 5 -> searchByVendor(sC);
                    case 6 -> customSearch(sC);


                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

    //!Creating a method that shows month to date Transactions
    public static void monthToDate() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n💰══════════════════════ MONTH TO DATE REPORT ══════════════════════════════════════════💰\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount" + Colors.RESET
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "💰══════════════════════════════════════════════════════════════════════════════════════💰"
                            + Colors.RESET
            );


            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*If statement  to only print out equal statement
                if (LocalDate.now().getMonth() == demo.getDate().getMonth() &&
                        LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }

    //!Creating a method that shows previous month Transaction
    public static void previousMonth() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n📅══════════════════════ PREVIOUS MONTH REPORT ═════════════════════════════════════════📅\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount" + Colors.RESET
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "📅══════════════════════════════════════════════════════════════════════════════════════📅"
                            + Colors.RESET
            );


            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //?Setting up my month placement
                LocalDate lastMonth = LocalDate.now().minusMonths(1);
                //*If statement  to only print out equal statement
                if (demo.getDate().getMonth() == lastMonth.getMonth() &&
                        LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    //!Creating a method that shows Year to date Transaction
    public static void yearToDate() {

        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n📈══════════════════════ YEAR TO DATE REPORT ═══════════════════════════════════════════📈\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(
                    Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount"
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "📈══════════════════════════════════════════════════════════════════════════════════════📈"
                            + Colors.RESET
            );

            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*If statement  to only print out equal statement
                if (LocalDate.now().getYear() == demo.getDate().getYear()) {

                    //*Display transaction info
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that shows previous year Transaction
    public static void previousYear() {

        ArrayList<Transaction> transactionsList = new ArrayList<>();

        //?Try catch to catch any unexpected errors
        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));


            //?Loop to go over all the transaction
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n📆══════════════════════ PREVIOUS YEAR REPORT ══════════════════════════════════════════📆\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(
                    Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount"
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "📆══════════════════════════════════════════════════════════════════════════════════════📆"
                            + Colors.RESET
            );

            //?To print out the sorted lists
            for (Transaction demo : transactionsList) {
                //*Setting up last year placement
                LocalDate lastYear = LocalDate.now().minusYears(1);
                //*If statement  to only print out equal statement
                if (demo.getDate().getYear() == lastYear.getYear()) {

                    //*Display transaction info
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that can search by vendor
    public static void searchByVendor(Scanner scanner) {
        //?Creating my list to track my transactions
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        try {
            //*BufferedReader to read the file
            BufferedReader bankReader = new BufferedReader(new FileReader("transaction.csv"));

            //*Asking question
            Thread.sleep(500);
            System.out.print(
                    Colors.PURPLE +
                            "\n🔍 Enter Vendor Name: "
                            + Colors.RESET
            );
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
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n🏪══════════════════════ SEARCH BY VENDOR REPORT ═══════════════════════════════════════🏪\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(
                    Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount"
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "🏪══════════════════════════════════════════════════════════════════════════════════════🏪"
                            + Colors.RESET
            );

            //?Creating a loop to display the transactions in order
            for (Transaction demo : transactionsList) {

                if (vendorName.contains(demo.getVendor())) {
                    //*Display transaction info
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    //*Changing the color for type depending on what kinda it is
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());

                }
            }
            bankReader.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //!Creating a method that can filter search
    public static void customSearch(Scanner scanner) {

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
            System.out.println(
                    Colors.PURPLE +
                            "📅 What's the Start Date? (Ex: 2025-06-20)\n" +
                            "Press Enter to Skip:"
                            + Colors.RESET
            );

            //*Catching the answer
            String start = scanner.nextLine().trim();

            //*parsing the date if they enter a date
            LocalDate startDate = start.isEmpty() ? null : LocalDate.parse(start);

            //*Asking for a end date
            System.out.println(
                    Colors.PURPLE +
                            "📅 What's the End Date? (Ex: 2025-06-20)\n" +
                            "Press Enter to Skip:"
                            + Colors.RESET
            );


            //*Catching the answer
            String end = scanner.nextLine().trim();

            //*parsing the date if they enter a date
            LocalDate endDate = end.isEmpty() ? null : LocalDate.parse(end);

            //*Asking for a type
            System.out.println(
                    Colors.PURPLE +
                            "🟢/🔴 What's the Type?\n" +
                            "Press Enter to Skip:"
                            + Colors.RESET
            );

            //*Catching the answer
            String type = scanner.nextLine().trim();

            //*Asking for a vendor
            System.out.println(
                    Colors.PURPLE +
                            "🏪 What's the Vendor?\n" +
                            "Press Enter to Skip:"
                            + Colors.RESET
            );

            //*Catching the answer
            String vendor = scanner.nextLine().trim();
            //*Asking for a description
            System.out.println(
                    Colors.PURPLE +
                            "📝 What's the Description?\n" +
                            "Press Enter to Skip:"
                            + Colors.RESET
            );

            //*Catching the answer
            String description = scanner.nextLine().trim();

            //*Asking for a dollar amount
            System.out.println(
                    Colors.PURPLE +
                            "💰 What's the Amount?\n" +
                            "Enter 0 to Skip:"
                            + Colors.RESET
            );

            //*Catching the answer
            double amount = scanner.nextDouble();
            Thread.sleep(500);
            //* Title
            System.out.println(
                    Colors.BLUE +
                            "\n🔍══════════════════════ CUSTOM SEARCH REPORT ════════════════════════════════════════🔍\n"
                            + Colors.RESET
            );
            Thread.sleep(500);
            System.out.printf(
                    Colors.BOLD +
                            "%-12s %-8s %-10s %-20s %-25s %10s\n",
                    "Date",
                    "Time",
                    "Type",
                    "Vendor",
                    "Description",
                    "Amount"
            );
            Thread.sleep(500);
            System.out.println(
                    Colors.BLUE +
                            "🔍══════════════════════════════════════════════════════════════════════════════════════🔍"
                            + Colors.RESET
            );

            //?Loop going through my transactions filtering out
            for (Transaction demo : transactionsList) {

                //?Setting up the filters
                boolean afterStart = startDate != null && demo.getDate().isAfter(startDate);
                boolean beforeEnd = endDate != null && demo.getDate().isBefore(endDate);
                boolean dateMatch = afterStart && beforeEnd;
                boolean typeMatch = demo.getType().equalsIgnoreCase(type);
                boolean vendorMatch = demo.getVendor().equalsIgnoreCase(vendor);
                boolean descriptionMatch = demo.getDescription().equalsIgnoreCase(description);
                boolean amountMatch = demo.getAmount() == amount;

                //? if statements to print out filter choice
                if (dateMatch && typeMatch && vendorMatch && descriptionMatch && amountMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && typeMatch && vendorMatch && descriptionMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && typeMatch && vendorMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && typeMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && vendorMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && descriptionMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (dateMatch && amountMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (typeMatch && vendorMatch && descriptionMatch && amountMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (typeMatch && vendorMatch && descriptionMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (typeMatch && vendorMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (typeMatch && descriptionMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (typeMatch && amountMatch) {

                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (vendorMatch && descriptionMatch && amountMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (vendorMatch && descriptionMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (vendorMatch && amountMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                } else if (descriptionMatch && amountMatch) {
                    String coloredType = demo.getType().equalsIgnoreCase("Deposit")
                            ? Colors.GREEN + demo.getType() + Colors.RESET
                            : Colors.RED + demo.getType() + Colors.RESET;
                    System.out.println(Colors.CYAN + "Transaction" + Colors.RESET);

                    System.out.printf("%-12s|%-8s|%-10s|%-20s|%-25s|%-10.2f\n\n",
                            demo.getDate(), demo.getTime(), coloredType, demo.getVendor(),
                            demo.getDescription(), demo.getAmount());
                }


            }


        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());

        }

    }


}

