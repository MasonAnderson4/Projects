package Q4;

public class BankAccount {
	String accountNumber;
	double balance;
	
	void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);

	}
	
	void withdraw(double amount) {
		if(balance > amount) {
			balance = balance - amount;
			System.out.println("Withdrawing $" + amount);
		}
		else {
			System.out.println("Insufficient balance");
			getBalance();
		}
	}
	
	double getBalance() {
		System.out.println("Current Balance: $" + balance);
		return balance;
	}
	

}