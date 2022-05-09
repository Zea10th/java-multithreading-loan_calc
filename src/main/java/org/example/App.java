package org.example;

public class App {
    public static void main(String[] args) {
        double amount = 2_500_000;
        int period = 24;
        double rate = 6.5;

        LoanCalculator calc = new LoanCalculator(amount, period, rate);

        System.out.printf("You want to get $%.2f on %d months by %.2f rate.\n", amount, period, rate);
        System.out.println("The result of loan calculation is below:");
        System.out.printf("1. Monthly payment is : $%.2f.\n" +
                "2. Total payout is : $%.2f.\n" +
                "3. Overpaid id : $%.2f.\n",
                calc.getLoanMonthlyPayment(),
                calc.getLoanTotalPrice(),
                calc.getLoanOverpaid());
    }
}
