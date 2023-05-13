public class Account {
    String accountNumber;
    double balance;

    Account (String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    double deposit() {
        double depositedAmount = 300;
        double newBalance = balance+depositedAmount;
        return (newBalance);
    }

    double withdraw() {
        return (balance-50);
    }

    void transctioned_amount(){
        System.out.println("Account # has done the following transaction");
    }

}

class CheckingAccount extends Account{
    double overdraftLimit;       //overdraft limit
    CheckingAccount(String accountNumber, double balance, double overdraftLimit){
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    boolean overdraft(){
//        CheckingAccount overdObj = new CheckingAccount();   //when an overdraft happens
        if (balance< 0) {
            return true;
        } 
        else {
            return false;
        }
    }
    //make if statement of overdraft, and new balance
    @Override
    void transctioned_amount() {
        if (overdraft() == true){
        System.out.println("Account with number: CJ8923 has overdrafted");
        }
    }
}

class SavingsAccount extends Account{
    double interestRate;         //savings account interest

    SavingsAccount(String accountNumber, double balance,double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    double calculateInterest() {
        return (balance*interestRate);
    }
    @Override
    void transctioned_amount(){
//        SavingsAccount SavObj = new SavingsAccount(0.03);
        System.out.println("Account number: "+accountNumber+" will accrue a total of $"+calculateInterest()+" a year from now.");
    }
}
class Main{
    public static void main(String[] args) {
        Account person1 = new Account("CJ8923", 1000);
        Account person2 = new CheckingAccount("CJ365",0,50);
        Account person3 = new SavingsAccount("SA765", 0, 0);
        person2.withdraw();
        
        person2.transctioned_amount();
    }
}
//asks to choose an account to register
//then store the data and polymorph the methods
