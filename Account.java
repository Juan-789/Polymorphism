public class Account {
    String accountNumber;
    double balance;
    public static void main(String[] args) {
//        make constructor of data
        Account person1 = new Account("CJ8923", 0);
        person1.s
    }

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
        System.out.print("Account with number: "+accountNumber+" has the following balance, after the "+" transaction occurred.");   //asks for withdrawal
    }
}

class CheckingAccount extends Account{
    double overdraftLimit;       //overdraft limit
    CheckingAccount(double overdraftLimit){
        super("CJ8923", 0);
        overdraftLimit = 100;
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
        System.out.println("Account with number: CJ8923 has");
    }
}

class SavingsAccount extends Account{
    double interestRate;         //savings account interest
    SavingsAccount(double interestRate){
        super("S45667", 700);
        this.interestRate = interestRate;
    }
    double calculateInterest() {
        return (balance*interestRate);
    }
    @Override
    void transctioned_amount(){
        System.out.println();
    }
}
//asks to choose an account to register
//then store the data and polymorph the methods
