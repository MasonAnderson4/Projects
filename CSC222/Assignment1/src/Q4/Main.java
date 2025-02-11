package Q4;

public class Main {

	public static void main(String[] args) {
		// Create two BankAccount objects
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		// Initialize attributes for account1
		account1.accountNumber = "12345";
		account1.balance = 1000;
		
		// Display initial balance for account1
		System.out.println("Account Number: " + account1.accountNumber);
		account1.getBalance();
		
		// Deposit and withdraw money from account1
		account1.deposit(500);
		account1.withdraw(200);
		account1.getBalance();
		System.out.println();
		
		// Initialize attributes for account2
		account2.accountNumber = "67890";
		account2.balance = 2000;
		
		// Display initial balance for account2
		System.out.println("Account Number: " + account2.accountNumber);
		account2.getBalance();
		
		// Deposit and withdraw money from account2
		account2.deposit(1000);
		account2.withdraw(500);
		account2.getBalance();

	}
}

