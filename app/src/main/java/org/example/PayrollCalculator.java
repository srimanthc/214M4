package org.example;

public class PayrollCalculator {
    public static final double PAY_RATE = 16.78;
    public static final double OVERTIME_MULTIPLIER = 1.5;
    public static final double SOC_SEC_RATE = 0.06;
    public static final double FED_TAX_RATE = 0.14;
    public static final double STATE_TAX_RATE = 0.05;
    public static final double UNION_DUES = 10.00;

    public static double calculateGrossPay(double hours) {
        if (hours <= 40) {
            return hours * PAY_RATE;
        } else {
            double overtime = hours - 40;
            return (40 * PAY_RATE) + (overtime * PAY_RATE * OVERTIME_MULTIPLIER);
        }
    }

    public static double insuranceCost(int dependents) {
        if (dependents >= 3) {
            return 35.00;
        } else {
            return 15.00;
        }
    }

    public static double calculateNetPay(double gross, int dependents) {
        double deductions = gross * (SOC_SEC_RATE + FED_TAX_RATE + STATE_TAX_RATE);
        deductions += UNION_DUES + insuranceCost(dependents);
        return gross - deductions;
    }

    public static void printReport(double hours, int dependents) {
        double gross = calculateGrossPay(hours);
        double socSec = gross * SOC_SEC_RATE;
        double fedTax = gross * FED_TAX_RATE;
        double stateTax = gross * STATE_TAX_RATE;
        double insurance = insuranceCost(dependents);
        double net = calculateNetPay(gross, dependents);

        System.out.println("\nPayroll Stub:\n");
        System.out.println("Hours:   " + hours);
        System.out.println("Rate:    $" + PAY_RATE + " /hr");
        System.out.println("Gross:   $" + String.format("%.2f", gross));
        System.out.println();
        System.out.println("SocSec:  $" + String.format("%.2f", socSec));
        System.out.println("FedTax:  $" + String.format("%.2f", fedTax));
        System.out.println("StTax:   $" + String.format("%.2f", stateTax));
        System.out.println("Union:   $" + UNION_DUES);
        System.out.println("Ins:     $" + String.format("%.2f", insurance));
        System.out.println();
        System.out.println("Net:     $" + String.format("%.2f", net));
    }
}
