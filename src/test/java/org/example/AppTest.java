package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    public static final double RATE = 5.5;
    public static final double AMOUNT = 5_000_000;
    public static final int PERIOD = 36;

    @Test
    void returnsTrueIfMonthlyPaymentCorrect() {
        LoanCalculator calc = new LoanCalculator(AMOUNT, PERIOD, RATE);

        double monthlyRate = RATE / 100 / 12;
        double expected = AMOUNT * monthlyRate / (1 - Math.pow(1 + monthlyRate, -PERIOD));
        double actual = calc.getLoanMonthlyPayment();

        assertTrue(actual == expected);
    }

    @Test
    void returnsTrueIfLoanTotalPriceCorrect() {
        LoanCalculator calc = new LoanCalculator(AMOUNT, PERIOD, RATE);

        double monthlyRate = RATE / 100 / 12;
        double monthlyPaiment = AMOUNT * monthlyRate / (1 - Math.pow(1 + monthlyRate, -PERIOD));
        double expected = monthlyPaiment * PERIOD;
        double actual = calc.getLoanTotalPrice();

        assertTrue(actual == expected);
    }

    @Test
    void returnsTrueIfOverpaidCorrect() {
        LoanCalculator calc = new LoanCalculator(AMOUNT, PERIOD, RATE);

        double monthlyRate = RATE / 100 / 12;
        double loanTotalPrice = PERIOD * AMOUNT * monthlyRate / (1 - Math.pow(1 + monthlyRate, -PERIOD));
        double expected = loanTotalPrice - AMOUNT;
        double actual = calc.getLoanOverpaid();

        assertTrue(actual == expected);
    }
}
