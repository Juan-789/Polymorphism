//Create a simple program that creates instances of the SavingsAccount and CheckingAccount classes and demonstrates the use of the methods in each class. 
//Use polymorphism to create an array of Account objects that can contain both SavingsAccount and CheckingAccount objects. 
//Use a loop to iterate through the array and call the appropriate methods for each object, demonstrating how polymorphism allows objects of 
//different types to be treated as if they are of the same type.
public class Account {
    String accountNumber;       //attributes
    double balance;
    String transaction;
    Account (String accountNumber, double balance, String transaction) {
        this.accountNumber = accountNumber;     //constructor
        this.balance = balance;
        this.transaction = transaction;
    }

    boolean deposit(double amount) {        //deposit method
        this.balance = balance+amount;
        return true;
    }

    boolean withdraw(double amount) {       //withdrawal method
        this.balance=balance-amount;
        return true;
    }

    void transctioned_amount(){             //polymorph method
        System.out.println("Account # has done the following transaction");
    }

}

class CheckingAccount extends Account{                  //child class
    double overdraftLimit;       //overdraft limit
    CheckingAccount(String accountNumber, double balance, String transaction, double overdraftLimit){       //constructor
        super(accountNumber, balance, transaction);
        this.overdraftLimit = overdraftLimit;
    }
    boolean overdraft(){        //when an overdraft happens
        if (this.balance< 0) {
            return true;
        } 
        else {
            return false;
        }
    }
    @Override
    void transctioned_amount() {            //polymorphed methd
        if (overdraft() == true){
            System.out.println("Account with number: "+accountNumber+" has overdrafted, and has a current balance of $"+balance+" after the "+transaction+" occured.");
        }
    }
}

class SavingsAccount extends Account{
    double interestRate;         //savings account interest

    SavingsAccount(String accountNumber, double balance, String transaction, double interestRate){  //constructor
        super(accountNumber, balance, transaction);
        this.interestRate = interestRate;
    }
    double calculateInterest() {        //interest calculator
        double interestGain = interestRate*this.balance;
        return (interestGain);
    }
    @Override
    void transctioned_amount(){     //polymorphed method
        System.out.println("Account number: "+accountNumber+" has a balance of $"+balance+" and will accrue a total of $"+calculateInterest()+" a year from now, and also performed a "+transaction+".");
    }
}
class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];    //creating array of Account objects
        accounts[0] = new CheckingAccount("CJ365", 0, "withdrew", 50);
        accounts[1] = new SavingsAccount("SA765", 50, "deposit", 0.03);

        for (Account account : accounts) {     //looping through the array
            if (account instanceof CheckingAccount) {    //checking type of object
                account.withdraw(20);
            } else if (account instanceof SavingsAccount) {
                account.deposit(50);
            }
            account.transctioned_amount();   //calling polymorphed method
        }
    }
}
