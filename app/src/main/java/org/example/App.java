package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Payroll Program!");
        System.out.println();

        System.out.print("How many hours did you work this week? ");
        double hours = scanner.nextDouble();

        System.out.print("How many children do you have? ");
        int dependents = scanner.nextInt();

        PayrollCalculator.printReport(hours, dependents);

        System.out.println();
        System.out.println("Thank you for using the Payroll Program!");
        scanner.close();
    }
}
