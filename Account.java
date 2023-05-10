import java.util.*;
public class Account {
    String accountNumber;
    double balance;

    public static void main(String[] args) {
        System.out.print("Input your account number: ");    //asks for acc. Number
        Scanner accNumObj = new Scanner(System.in);
        String accNum = accNumObj.nextLine();
        Account object = new Account();
        object.setAccountNumber(accNum);
        accNumObj.close();

        System.out.print("Input your account balance: ");   //asks for acc. balance
        Scanner accBalObj = new Scanner(System.in);
        double accBal = accBalObj.nextDouble();
        object.setBalance(accBal);
        accBalObj.close();

        System.out.print("Input 'd' for deposit, and 'w' if you want to perform a withdrawal ");
    }

    public void setAccountNumber(String accountNumber) {    //sets acc. number
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {            //sets balance
        this.balance = balance;
    }

    double deposit() {
        Scanner depositObj = new Scanner(System.in);
        System.out.print("How much would you like to deposit? ");   //asks for deposit
        double depositedAmount = depositObj.nextDouble();
        depositObj.close();
        return (balance+depositedAmount);
    }
    double withdraw() {
        Scanner withdrawObj = new Scanner(System.in);
        System.out.print("How much would you like to deposit? ");   //asks for withdrawal
        double withdrawAmount = withdrawObj.nextDouble();
        withdrawObj.close();
        return (balance-withdrawAmount);
    }
}

class CheckingAccount extends Account{
    double overdraftLimit() {       //overdraft limit
    return(balance+50);
    }

    double overdraft(){
        CheckingAccount overdObj = new CheckingAccount();   //when an overdraft happens
        double overWithdrawal = overdObj.withdraw();
        return (balance-overWithdrawal);
    }
    
    void statement() {
        System.out.println("commit of the day (lol close one)");
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
