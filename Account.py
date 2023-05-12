# Polymorphism
import java.util.*;
public class Account {
    String accountNumber;
    double balance;
    public static void main(String[] args) {
        //make constructor of data
        Account person1 = new Account("S45667", 700);
        Account person2 = new Account("CJ8923", 700);
        Account person3 = new Account("578785", 700);
    }

    Account (String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    double deposit() {
        Scanner depositObj = new Scanner(System.in);
        System.out.print("How much would you like to deposit? ");   //asks for deposit
        double depositedAmount = depositObj.nextDouble();
        double newBalance = balance+depositedAmount;
//        System.out.println(accountNumber+" new balance is "+ newBalance);
        depositObj.close();
        return (newBalance);
    }
    double withdraw() {
        Scanner withdrawObj = new Scanner(System.in);
//        System.out.print("How much would you like to withdraw? ");   //asks for withdrawal
        double withdrawAmount = withdrawObj.nextDouble();
        withdrawObj.close();
        return (balance-withdrawAmount);
    }

    void transctioned_amount(){
        System.out.print("Account with number: "+accountNumber+" has the following balance, after the "+" transaction occurred.");   //asks for withdrawal
    }
}

class CheckingAccount extends Account{
    double overdraftLimit() {       //overdraft limit
    return(balance+100);
    }
    boolean overdraft(){
        CheckingAccount overdObj = new CheckingAccount();   //when an overdraft happens
        if (balance< 0) {
            return true;
        } 
        else {
            return false;
        }
    }
    //make if statement of overdraft, and new balance
    void transctioned_amount() {
        System.out.println("Account with number: "+accountNumber+" ");
    }
}

class SavingsAccount extends Account{
    double interestRate = 0.03;         //savings account interest
    double calculateInterest() {
        return (balance*interestRate);
    }
}
//asks to choose an account to register
//then store the data and polymorph the methods
