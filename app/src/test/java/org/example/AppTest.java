package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayrollCalculatorTest {

    // test base pay when under 40 hours
    @Test
    void testGrossPayRegularHours() {
        double result = PayrollCalculator.calculateGrossPay(30);
        assertEquals(30 * 16.78, result, 0.01);
    }

    // test pay with overtime (more than 40 hrs)
    @Test
    void testGrossPayWithOvertime() {
        double result = PayrollCalculator.calculateGrossPay(45);
        double expected = (40 * 16.78) + (5 * 16.78 * 1.5);
        assertEquals(expected, result, 0.01);
    }

    // test insurance cost when under 3 dependents
    @Test
    void testInsuranceCostLowDependents() {
        double result = PayrollCalculator.insuranceCost(1);
        assertEquals(15.00, result, 0.01);
    }

    // test insurance cost when 3 or more dependents
    @Test
    void testInsuranceCostHighDependents() {
        double result = PayrollCalculator.insuranceCost(4);
        assertEquals(35.00, result, 0.01);
    }

    // test net pay with low dependents
    @Test
    void testNetPayLowDependents() {
        double gross = PayrollCalculator.calculateGrossPay(40);
        double expectedDeductions = gross * (0.06 + 0.14 + 0.05) + 10 + 15;
        double expectedNet = gross - expectedDeductions;
        double actualNet = PayrollCalculator.calculateNetPay(gross, 2);
        assertEquals(expectedNet, actualNet, 0.01);
    }

    // test net pay with high dependents
    @Test
    void testNetPayHighDependents() {
        double gross = PayrollCalculator.calculateGrossPay(40);
        double expectedDeductions = gross * (0.06 + 0.14 + 0.05) + 10 + 35;
        double expectedNet = gross - expectedDeductions;
        double actualNet = PayrollCalculator.calculateNetPay(gross, 5);
        assertEquals(expectedNet, actualNet, 0.01);
    }
}
