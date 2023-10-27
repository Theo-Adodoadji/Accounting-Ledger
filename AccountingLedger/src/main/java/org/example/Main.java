package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, welcome to the Accounting Ledger!");

        ArrayList<Transactions> transactionList = new ArrayList<>();

        boolean continueRunning = true;
        //homescreen

        while (continueRunning) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What do you want to do? Type the letter");
            System.out.println(" D) Add a deposit");
            System.out.println(" P) Make Payment");
            System.out.println(" L) Ledger (display the ledger screen)");
            System.out.println(" X) - Exit");

            String userInputHome = scanner.nextLine();
            userInputHome = userInputHome.toLowerCase();

            switch (userInputHome) {
                case "d":

                    System.out.println("You would like to make a deposit!");


                    //properties and fields

                        System.out.println("Okay we will first get your date!");
                        LocalDate date = LocalDate.now();
                        System.out.println(date);
                        System.out.println("Now we will get your time!");
                        LocalTime time = LocalTime.now();
                        System.out.println(time);
                        System.out.println("Enter the item you would like to deposit in");
                        String userInputdescription = scanner.nextLine();
                        System.out.println("Please enter the vendor name");
                        String userInputvendor = scanner.nextLine();
                        System.out.println("Enter the amount you would like to deposit");
                        Double userInputamount = scanner.nextDouble();
                        scanner.nextLine();

                        //A print out of the summary
                        System.out.println(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputdescription + "|" + userInputvendor + "|" + userInputamount + "\n");
                        try {
                            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);

                            Transactions depositTransaction = new Transactions("date", "time", "userInputdescription", "userInputvendor", userInputamount);
                            transactionList.add(depositTransaction);

                            //append means add on to the end of something
                            fileWriter.write(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputdescription + "|" + userInputvendor + "|" + userInputamount + "\n");

                            fileWriter.close();
                        } catch (IOException ex) {
                            System.out.println("Had a problem writing in the file, I'm sorry");
                        }

                        break;

                        //very similar to make a deposit
                        case "p":

                            System.out.println("You would like to make a Payment!");
                            System.out.println("Okay we will first get your date!");
                             date = LocalDate.now();
                            System.out.println(date);
                            System.out.println("Now we will get your time!");
                             time = LocalTime.now();
                            System.out.println(time);
                            System.out.println("Enter the item you would like to make a payment for");
                             userInputdescription = scanner.nextLine();
                            System.out.println("Please enter the vendor name");
                             userInputvendor = scanner.nextLine();
                            System.out.println("Enter the amount you would like to pay");
                             Double userInputPayAmount = scanner.nextDouble();
                            scanner.nextLine();

                            //A print out of the summary
                            System.out.println(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputdescription + "|" + userInputvendor + "|" + userInputPayAmount + "\n");
                            try {
                                FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);

                                Transactions paymentTransaction = new Transactions("date", "time", "userInputdescription", "userInputvendor", userInputPayAmount);
                                transactionList.add(paymentTransaction);

                                //append means add on to the end of something
                                fileWriter.write(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputdescription + "|" + userInputvendor + "|" + userInputPayAmount + "\n");

                                fileWriter.close();
                            } catch (IOException ex) {
                                System.out.println("Had a problem writing in the file, I'm sorry");
                            }

                            break;


                        case "l":
                            System.out.println("You are at the ledger screen! What do you want to do? Please select a letter.");
                            System.out.println(" A) Display all entries");
                            System.out.println(" D) Display all deposits");
                            System.out.println(" P) Display all payments");
                            System.out.println(" R) Display all Reports");

                            String userInputLedger = scanner.nextLine();
                            userInputLedger = userInputLedger.toLowerCase();

                            switch (userInputLedger) {
                                case "a":

                                    System.out.println("Here are all the entries:");
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");

                                        Scanner banner = new Scanner(fileInputStream);

                                        String input;

                                        while (banner.hasNextLine()) {
                                            input = banner.nextLine();
                                            System.out.println(input);

                                        }

                                    } catch (FileNotFoundException ex) {
                                        System.out.println("Could not find the file.");
                                    }
                                    break;


                                case "d":
                                    System.out.println("Here are all the deposits:");
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                        Scanner banner = new Scanner(fileInputStream);

                                        String input;

                                        while (banner.hasNextLine()) {
                                            input = banner.nextLine();
                                            // Split the CSV line into parts (assuming a comma-separated format)
                                            String [] transaction = input.split("\\|");
                                            if (transaction.length >= 5) {
                                                String transactionType = transaction[5]; // The amount is in the fifth column

                                                if (transactionType.equals("deposit")) {
                                                    System.out.println(input);
                                                }
                                                }
                                            }


                                    } catch (FileNotFoundException ex) {
                                        System.out.println("Could not find the file.");
                                    }

                                    break;

                                case "p":
                                    System.out.println("Here are all the payments:");
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                        Scanner banner = new Scanner(fileInputStream);

                                        String input;

                                        while (banner.hasNextLine()) {
                                            input = banner.nextLine();
                                            // Split the CSV line into parts (assuming a comma-separated format)
                                            String [] transaction = input.split("\\|");
                                            if (transaction.length >= 5) {
                                                String transactionType = transaction[5]; // The amount is in the fifth column

                                                if (transactionType.equals("payment")) {
                                                    System.out.println(input);
                                                }
                                            }
                                        }


                                    } catch (FileNotFoundException ex) {
                                        System.out.println("Could not find the file.");
                                    }
                                    break;

                                case "r":
                                    boolean stayOnReportsScreen = true;
                                    //Show all reports
                                    while (stayOnReportsScreen) {

                                    System.out.println("You are at the Reports screen! What do you want to do? Please select a number to custom search.");
                                    System.out.println(" 1) Month to Date");
                                    System.out.println(" 2) Previous Month");
                                    System.out.println(" 3) Year to Date");
                                    System.out.println(" 4) Previous Year");
                                    System.out.println(" 5) Search by Vendor");
                                    System.out.println(" 0) Back- Go back to the report page");

                                    int userInputReport = scanner.nextInt();
                                    switch (userInputReport) {

                                        case 1:
                                            System.out.println("Here all the Month to Date entries");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    // Split the CSV line into parts (assuming a comma-separated format)
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0]; // Assuming the date is in the first column

                                                        // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                                                        if (transactionDate.matches("\\d{4}-10-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("Could not find the file.");
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Here all the Previous month entries");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    // Split the CSV line into parts (assuming a comma-separated format)
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0]; // Assuming the date is in the first column

                                                        // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                                                        if (transactionDate.matches("\\d{4}-09-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("Could not find the file.");
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Here all the Year to Date entries");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    // Split the CSV line into parts (assuming a comma-separated format)
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0]; // Assuming the date is in the first column

                                                        // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                                                        if (transactionDate.matches("2023-\\d{2}-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("Could not find the file.");
                                            }
                                            break;

                                        case 4:
                                            System.out.println("Here all the Previous year entries");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    // Split the CSV line into parts (assuming a comma-separated format)
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0]; // Assuming the date is in the first column

                                                        // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                                                        if (transactionDate.matches("2022-\\d{2}-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("Could not find the file.");
                                            }
                                            break;

                                        case 5:
                                            System.out.println("Here all the entries to search by Vendor");
                                            System.out.println("Which vendor would you like to search by?");
                                            String userInputVendor = scanner.nextLine();
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    // Split the CSV line into parts (assuming a comma-separated format)
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionVendor = transaction[4]; // Assuming the vendor is in the fourth column

                                                        if (userInputVendor.equalsIgnoreCase(transactionVendor)) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("Could not find the file.");
                                            }
                                            break;

                                        case 0:
                                            stayOnReportsScreen = false;
                                            break;
                                        default:
                                            System.out.println("You may select 1, 2, 3, 4, 5, or 0");
                                            break;
                                        }
                                    }
                                case "h":
                                    System.out.println("Okay! Let's take you back to the homescreen");
                                    break;

                            }
                            break;

                        case "x":
                            System.out.println("You have exited!");
                            continueRunning = false;
                            break;
                        default:
                            //System.out.println("You may select D, P, L, or X");
                            break;

                    }

            }
        }


    }
// 2023-04-29|13:45:25|Webcam|Best Buy|-59.99