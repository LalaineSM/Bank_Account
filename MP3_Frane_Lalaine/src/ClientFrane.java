/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//@author lsmfrane
import java.util.Scanner;

//main class
public class ClientFrane {

    public static void main(String[] args) {   //question 4                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        //display main menu
        Scanner input = new Scanner(System.in); //System.in is a standard input stream
        //boolean mainLoop = true;
        boolean acctNumMatches = false;
        String choice = "";
        SavingsAccountFrane account1 = new SavingsAccountFrane(); //instantiated in the main method - question 5

        while (!choice.equals("7")) {
            String accountName;
            String address;
            String birthDate;
            String contactNo;
            String depositAmount = "";
            String withdrawAmount;
            double balance = 0.0;
            String answer;
            boolean yn;

            System.out.println("Bank Main Menu");
            System.out.println("[1] New Account");
            System.out.println("[2] Balance Inquiry");
            System.out.println("[3] Deposit");
            System.out.println("[4] Withdraw");
            System.out.println("[5] Client Profile");
            System.out.println("[6] Close Account");
            System.out.println("[7] Exit");
            System.out.println("Please select an option: ");

            choice = input.nextLine();

            switch (choice) {
                case "1": //new account
                    System.out.println("You are now creating an account.");
                    System.out.print("Please enter your full name: ");
                    accountName = input.nextLine();

                    System.out.print("Please enter your address: ");
                    address = input.nextLine();

                    System.out.print("Please enter your birth date in the format MM-DD-YYYY: ");
                    birthDate = input.nextLine();

                    System.out.print("Please enter your Contact No: ");
                    contactNo = input.nextLine();

                    System.out.println("New account creation requires a deposit of not less than Php5,000. How much will you deposit? ");

                    while (true) {
                        depositAmount = input.nextLine();
                        if (Integer.parseInt(depositAmount) >= 5000) {
                            break;
                        }
                        System.out.println("Invalid amount. New account creation requires a deposit of not less than Php5,000. How much will you deposit? ");
                    }

                    System.out.println("Thank you for providing your information. You have successfully created an account. Your details are below.");


                    account1.getClientInputs(accountName, address, birthDate, contactNo, depositAmount); //set data inputs
                    account1.displayClientProfile(); //show client info
                    pressEnterToContinue();
                    System.out.println("\n\n\n\n\n");

                    break;
                case "2": //balance inquiry
                    System.out.println("You are now checking your account balance.");
                    System.out.println("Please enter your Account No. to proceed: ");
                    String accountNumberInput = input.nextLine();

                    if (account1.validateAccountNo(accountNumberInput)) { //account validation
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Account Name: " + account1.getAccountName());
                        System.out.println("Current Balance: " + account1.getBalance());
                        System.out.println("------------------------------------------------------------");
                        pressEnterToContinue();
                    } else {
                        System.out.println("Invalid account number. Exiting the program.");
                    }

                    break;
                case "3": //deposit
                    System.out.println("You are now depositing to your account.");
                    System.out.println("Please enter your Account No. to proceed: ");
                    accountNumberInput = input.nextLine();

                    if (account1.validateAccountNo(accountNumberInput)) {
                        while (true) {
                            System.out.println("Deposits cannot be less than Php100. How much will you deposit? ");
                            depositAmount = input.nextLine();
                            if (Double.parseDouble(depositAmount) >= Double.parseDouble("100")) {
                                account1.deposit(Integer.parseInt(depositAmount)); //save deposit
                                break;
                            } else {
                                System.out.println("Invalid amount. Deposits cannot be less than Php100. How much will you deposit? ");
                            }
                        }
                        System.out.println("Thank you for providing your information. You have successfully deposited to your account. Your details are below.");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Account Name: " + account1.getAccountName());
                        System.out.println("Current Balance: " + account1.getBalance());
                        System.out.println("------------------------------------------------------------");
                        pressEnterToContinue();
                        System.out.println("\n\n\n\n\n");

                    } else {
                        System.out.println("Invalid account number. Exiting the program.");
                    }
                    break;
                case "4": //withdraw
                    boolean validWithdrawAmount = false;
                    System.out.println("You are now withdrawing from your account.");
                    System.out.println("Please enter your Account No. to proceed: ");
                    accountNumberInput = input.nextLine();

                    if (account1.validateAccountNo(accountNumberInput)) {
                        while (true) {
                            System.out.println("Withdrawals cannot be less than Php100. How much will you withdraw? ");
                            System.out.println("[Press 'n' to cancel. ]");                            
                            withdrawAmount = input.nextLine();

                            
                            if (withdrawAmount.equals("n")) {
                                System.out.println("Invalid account number. Exiting the program.");
                                pressEnterToContinue();
                                break;
                            }
                            
                            validWithdrawAmount = Double.parseDouble(withdrawAmount) >= Double.parseDouble("100");
                            validWithdrawAmount = validWithdrawAmount && Double.parseDouble(withdrawAmount) <= (account1.getBalance() - 5000);
                                
                            if (validWithdrawAmount) {
                                account1.withdraw(Integer.parseInt(withdrawAmount));
                                
                                System.out.println("Thank you for providing your information. You have successfully deposited to your account. Your details are below.");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Account Name: " + account1.getAccountName());
                                System.out.println("Current Balance: " + account1.getBalance());
                                System.out.println("------------------------------------------------------------");
                                pressEnterToContinue();
                                System.out.println("\n\n\n\n\n");
                                break;
                            }
                        }
                    } else {
                            System.out.println("Invalid account number. Exiting the program.");
                    }
                    break;
                case "5": //client profile
                    System.out.println("You are now accessing your account profile.");
                    System.out.println("Please enter your Account No. to proceed: ");
                    accountNumberInput = input.nextLine();

                    if (account1.validateAccountNo(accountNumberInput)) {//account validation
                        System.out.println("Thank you for providing your information. You have successfully deposited to your account. Your details are below. ");
                        account1.displayClientProfile(); //show client info
                        pressEnterToContinue();
                    } else {
                        System.out.println("Invalid account number. Exiting the program.");
                    } 
                    break;
                case "6": //close account - question 12
                    System.out.println("You are attempting to close your account.");
                    System.out.println("Please enter your Account No. to proceed: ");
                    accountNumberInput = input.nextLine();

                    if (account1.validateAccountNo(accountNumberInput)) { //account validation
                        System.out.println("Please confirm if you'd like to close your account. [Y / N]");

                        while (true) {
                            answer = input.nextLine().trim().toLowerCase();
                            if (answer.equals("y")) {
                                yn = true;
                                account1.setBalance(0.0);
                                System.out.println("Confirming you have successfully closed your account. ");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Account Name: " + account1.getAccountName());
                                System.out.println("Current Balance: " + account1.getBalance());
                                System.out.println("Account Status: Closed");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("\n\n\n\n\n");
                                break;
                            } else {
                                System.out.println("We did not receive confirmation of your account closure. Redirecting you to the main menu. ");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid account number. Exiting the program.");
                    }
                    break;
                case "7": //exit
                    System.out.println("Exiting program...");
                    // simply terminates the run
                    return;
                //break;
                default:
                    System.out.println("This is not a valid option. Please try again. ");
                    break;
            }
            // reset your choice and avoids previous selection
            choice = "";
        }
    }

    private static void pressEnterToContinue() {
        // for pressing enter to continue 
        // this accepts the "enter" character and not skip the choice input

        Scanner input = new Scanner(System.in);
        System.out.print("Press enter to continue...");
        input.nextLine();
    }
}
