📜 Accounting Ledger Application

A Java-based command-line accounting ledger system that allows users to record deposits, make payments, store transaction history, and generate financial reports.

The application simulates a simple bookkeeping system for Avatar Figures & Collectibles and stores all transaction data in a CSV file for persistent storage.

🚀 Features

🟢 Add Deposits

Users can:

Enter a deposit amount

Enter a vendor/source

Enter a description

Automatically save the transaction with the current date and time

🔴 Make Payments

Users can:


Record outgoing payments

Enter a vendor

Enter a description

Automatically store payments as negative amounts

📜 View Ledger

View all transaction activity with options to display:

All Transactions

Deposits Only

Payments Only

Transactions are automatically sorted from newest to oldest.

📊 Reports

Generate reports including:


Month-To-Date

Previous Month

Year-To-Date

Previous Year

Search By Vendor

Custom Search Filters

📂 Project Structure

accounting-ledger/
│

├── .idea/

├── .mvn/

├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── com.pluralsight/

│   │   │       ├── AccountLedgerApp.java

│   │   │       ├── Transaction.java

│   │   │       └── Colors.java

│   │   │

│   │   └── resources/

│   │

│   └── test/

│

├── target/

├── transaction.csv

├── pom.xml

├── .gitignore

└── README.md

📄 Classes

AccountLedgerApp.java

The main application class is responsible for:

Displaying menus

Handling user input

Creating deposits

Creating payments

Reading transaction data

Displaying reports

Searching transactions

Transaction.java

Represents an individual transaction object.

Stores:

LocalDate date;

LocalTime time;

String type;

String vendor;

String description;

double amount;

Provides constructors and getter methods for transaction management.

Colors.java

Contains ANSI color constants used to improve readability and appearance within the console application.

Examples:

Colors.RED

Colors.GREEN

Colors.BLUE

Colors.CYAN

Colors.PURPLE

Colors.RESET

💾 Transaction Storage

All transaction data is stored in:

transaction.csv

Format:

Date|Time|Type|Vendor|Description|Amount

Example:

2026-11-05|14:08|Deposit|JPMorgan|Work Income|2000

2026-11-05|14:15|Payment|Amazon|Collectible Purchase|-59.99

2026-10-28|16:27|Deposit|CashApp|Gift|150

This file acts as the application's persistent storage and is automatically updated whenever a deposit or payment is entered.

📊 Available Reports

Month-To-Date Report

Displays all transactions from the current month.

Previous Month Report

Displays all transactions from the previous month.

Year-To-Date Report

Displays all transactions from the current year.

Previous Year Report

Displays all transactions from the previous year.

Search By Vendor

Displays transactions matching a specific vendor name.

Custom Search

Allows filtering by:

Start Date

End Date

Transaction Type

Vendor

Description

Amount

Users can leave fields blank to skip filters.

🛠 Technologies Used
Java
Maven
Object-Oriented Programming (OOP)
ArrayList Collections
BufferedReader
BufferedWriter
FileReader
FileWriter
Scanner
LocalDate
LocalTime
Comparator Sorting
CSV File Storage
Exception Handling
▶️ Running The Application
Clone the Repository
git clone https://github.com/your-username/accounting-ledger.git
Navigate to Project Directory
cd accounting-ledger
Compile and Run
Using Maven:

mvn compile
mvn exec: java
Or run directly from IntelliJ IDEA.

🧠 Concepts Demonstrated
This project demonstrates:

Object-Oriented Programming
File Handling
Data Persistence
Menu-Driven Applications
Date and Time Processing
Transaction Filtering
Search Functionality
Report Generation
Collections Framework
Exception Handling
🔮 Future Improvements
Potential enhancements include:

Running account balance
Edit existing transactions
Delete transactions
Export reports to Excel
Category tracking
Budget management
Database integration (MySQL/PostgreSQL)
Graphical User Interface (GUI)
Multi-user support
👨‍💻 Author
Messie Rutayomba
A Java-based accounting ledger application that records deposits and payments, stores transaction history in a CSV file, and generates detailed financial reports through a console-based interface.

