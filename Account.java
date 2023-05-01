import java.util.*;
public class Account {
    String accountNumber;
    double balance;

    public static void main(String[] args) {
        System.out.println("Hi!");
        
    }
    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    double deposit() {
        Scanner depositObj = new Scanner(System.in);
        System.out.print("How much would you like to deposit? ");
        double depositedAmount = depositObj.nextDouble();
        return balance+depositedAmount;

    }
    double withdraw() {
        Scanner withdrawObj = new Scanner(System.in);
        System.out.print("How much would you like to deposit? ");
        double withdrawAmount = withdrawObj.nextDouble();
        return balance-withdrawAmount;
    }
}
