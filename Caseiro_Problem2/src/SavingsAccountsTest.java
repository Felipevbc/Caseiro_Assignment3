public class SavingsAccountTest {

	public static void main(String[] args) {
		
    int Months;
		
    SavingsAccount Saver1 = new SavingsAccount(2000);
		
		SavingsAccount Saver2 = new SavingsAccount(3000);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.println("Your current balance is:\n");
		System.out.format("%-8s %8s %9s\n", "Month", "Saver1", "Saver2");
		
		for (Months = 0; Months < 13;Months++) {
			
      Saver1.calculateMonthlyInterest();
			Saver2.calculateMonthlyInterest();
			System.out.format("%-8d %9.2f %9.2f\n", Months + 1, Saver1.savingsBalance, Saver2.savingsBalance);
			
			if (Months == 11) {
				SavingsAccount.modifyInterestRate(0.05);
			}	
		}
	}
}
