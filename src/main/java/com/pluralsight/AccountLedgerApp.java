package com.pluralsight;

import java.util.Scanner;

public class AccountLedgerApp {


    public static void main(String[] args) {

        //?Creating my scanner
        Scanner input = new Scanner(System.in);


        //?Loop for the menu

        boolean menuApp = true;
        while (menuApp) {
            int command = displayHomeMenu(input);


            //*Navigating through the menu
            switch (command) {
//                case 1 ->    ;
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

}