/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//@author lsmfrane
import java.util.Random;

//subclass - question 2
public class SavingsAccountFrane extends BankAccountFrane { //question 3

    Random rand = new Random();

    //attributes - question 2
    private String accountNo;
    private double balance;
    final double interestRate = 0.05;

    private Boolean acctNumMatches;

    //constructor
    public SavingsAccountFrane() {
        this.balance = 0;
        //this.interestRate = 5/100;
        this.accountNo = String.format("%04d", rand.nextInt(10000));
        this.acctNumMatches = false;
    }

    //setter,  getters, and methods
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    //FOR WITHDRAW METHOD
    public void withdraw(double withdrawAmount) {
        this.balance = this.balance - withdrawAmount;
    }

    //FOR DEPOSIT METHOD
    public void deposit(double depositAmount) {
        this.balance = this.balance+ (this.balance * interestRate) + depositAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean validateAccountNo(String accountNumberInput) {
        // automatically returns a boolean value
        return this.accountNo.equals(accountNumberInput);
    }

    public void getClientInputs(String accountNameInput, String addressInput, String birthDateInput, String contactNoInput, String depositInput) {
        setAccountName(accountNameInput);
        setAddress(addressInput);
        setBirthDate(birthDateInput);
        setContactNo(contactNoInput);

        setBalance(Integer.parseInt(depositInput));
    }

    public void displayClientProfile() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Address: " + getAddress());
        System.out.println("Birth Date: " + getBirthDate());
        System.out.println("Contact No: " + getContactNo());

        System.out.println("Account No: " + accountNo);
        System.out.println("Current Balance: " + getBalance());
        System.out.println("------------------------------------------------------------");
    }

}
