// Base class
class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn from Account: " + amount);
        } else {
            System.out.println("Insufficient funds in base Account.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn from SavingsAccount: " + amount);
        } else {
            System.out.println("Insufficient funds in SavingsAccount.");
        }
    }
}

// CheckingAccount class
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn from CheckingAccount: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded in CheckingAccount.");
        }
    }
}

// Main class to demonstrate polymorphism
public class Main {
    public static void main(String[] args) {
        // Polymorphic array of accounts
        Account[] accounts = new Account[2];
        accounts[0] = new SavingsAccount("SA001", "Abdulaziz", 1000.0, 0.04);
        accounts[1] = new CheckingAccount("CA001", "Ali", 500.0, 300.0);

        // Loop to process all accounts polymorphically
        for (Account acc : accounts) {
            acc.displayAccountInfo();
            acc.withdraw(600); // Will call the appropriate overridden method
            System.out.println();
        }
    }
}
