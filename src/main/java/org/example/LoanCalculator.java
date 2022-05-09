package org.example;

public class LoanCalculator {
    private final double AMOUNT;
    private final int PERIOD;
    private final double MONTHLY_RATE;

    public LoanCalculator(double amount, int period, double rate) {
        AMOUNT = amount;
        PERIOD = period;
        MONTHLY_RATE = rate / 100 / 12;
    }

    public double getLoanMonthlyPayment() {
        return AMOUNT * MONTHLY_RATE /(1 - Math.pow(1 + MONTHLY_RATE, - PERIOD));
    }

    public double getLoanTotalPrice() {
        return getLoanMonthlyPayment() * PERIOD;
    }

    public double getLoanOverpaid() {
        return getLoanTotalPrice() - AMOUNT;
    }
}
