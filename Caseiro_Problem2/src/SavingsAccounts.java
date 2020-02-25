public class SavingsAccount {

private static double AnnualInterestRate = 0;
public double SavingsBalance;
	
public SavingsAccount (double Balance) {
	SavingsBalance = Balance;
	}

public void CalculateMonthlyInterest() {
		SavingsBalance += SavingsBalance * (AnnualInterestRate / 12);
	}
	
public static void ModifyInterestRate (double NewRate) {
		AnnualInterestRate = NewRate;
	}
}
