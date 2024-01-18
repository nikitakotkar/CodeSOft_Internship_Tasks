import java.util.Scanner;

class BankAccount {
  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public boolean withdraw(double amount) {
    if (amount > balance) {
      return false; // Insufficient funds
    }
    balance -= amount;
    return true; // Withdrawal successful
  }
}

class ATM {
  private BankAccount bankAccount;

  public ATM(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  public void withdraw(double amount) {
    if (bankAccount.withdraw(amount)) {
      System.out.printf("Withdrawal successful. Remaining balance: Rs%.2f\n", bankAccount.getBalance());
    } else {
      System.out.println("Error: Insufficient funds. Withdrawal failed.");
    }
  }

  public void deposit(double amount) {
    bankAccount.deposit(amount);
    System.out.printf("Deposit successful. New balance: Rs%.2f\n", bankAccount.getBalance());
  }

  public void checkBalance() {
    System.out.printf("Current balance: Rs%.2f\n", bankAccount.getBalance());
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("-----------------------------------------------------------------");
    System.out.print("Enter initial balance for your bank account: Rs");
    double initialBalance = scanner.nextDouble();
    BankAccount userAccount = new BankAccount(initialBalance);
    ATM atm = new ATM(userAccount);

    // User interface loop
    while (true) {
      System.out.println("-----------------------------------------------------------------");
      System.out.println("\nWelcome to the ATM Machine");
      System.out.println("-----------------------------------------------------------------");
      System.out.println("1. Withdraw");
      System.out.println("2. Deposit");
      System.out.println("3. Check Balance");
      System.out.println("4. Exit");
      System.out.print("Select an option (1-4): ");

      int choice = scanner.nextInt();
      System.out.println("-----------------------------------------------------------------");

      switch (choice) {
        case 1:
          System.out.print("Enter withdrawal amount: Rs");
          double withdrawAmount = scanner.nextDouble();
          System.out.println("-----------------------------------------------------------------");
          atm.withdraw(withdrawAmount);
          break;
        case 2:
          System.out.print("Enter deposit amount: Rs");
          double depositAmount = scanner.nextDouble();
          System.out.println("-----------------------------------------------------------------");
          atm.deposit(depositAmount);
          break;
        case 3:
          atm.checkBalance();
          break;
        case 4:
          System.out.println("Thank you for using the ATM. Goodbye!");
          System.out.println("-----------------------------------------------------------------");
          scanner.close();
          System.exit(0);
        default:
          System.out.println("Error: Invalid choice. Please select a valid option.");
      }
    }
  }
}
