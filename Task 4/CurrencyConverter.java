// TASK 4
// CURRENCY CONVERTER:

// Currency Selection: Allow the user to choose the base currency and the target currency.
// Currency Rates: Fetch real-time exchange rates from a reliable API.
// Amount Input: Take input from the user for the amount they want to convert.
// Currency Conversion: Convert the input amount from the base currency to the target currency using the fetched exchange rate.
// Display Result: Show the converted amount and the target currency symbol to the user.

import java.util.*;

public class CurrencyConverter {

    // Exchange rates (as of 01/05/2024)
    private static final double USD_TO_INR = 83.47;
    private static final double INR_TO_USD = 0.0119804;
    private static final double EUR_TO_INR = 89.10;
    private static final double INR_TO_EUR = 0.0113;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Currency Converter ===");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.println("3. Euro to INR");
        System.out.println("4. INR to Euro");
        System.out.print("Enter your choice (1 to 4): ");
        int choice = scanner.nextInt();

        double amount;
        switch (choice) {
            case 1:
                System.out.print("Enter amount in USD: ");
                amount = scanner.nextDouble();
                System.out.printf("Converted amount in INR: ₹%.2f\n", usdToInr(amount));
                break;
            case 2:
                System.out.print("Enter amount in INR: ");
                amount = scanner.nextDouble();
                System.out.printf("Converted amount in USD: $%.2f\n", inrToUsd(amount));
                break;
            case 3:
                System.out.print("Enter amount in Euro: ");
                amount = scanner.nextDouble();
                System.out.printf("Converted amount in INR: ₹%.2f\n", euroToInr(amount));
                break;
            case 4:
                System.out.print("Enter amount in INR: ");
                amount = scanner.nextDouble();
                System.out.printf("Converted amount in Euro: €%.2f\n", inrToEuro(amount));
                break;
            default:
                System.out.println("Invalid choice. Please select between 1 and 4.");
        }

        scanner.close();
    }

    // Conversion methods
    public static double usdToInr(double usd) {
        return usd * USD_TO_INR;
    }

    public static double inrToUsd(double inr) {
        return inr * INR_TO_USD;
    }

    public static double euroToInr(double euro) {
        return euro * EUR_TO_INR;
    }

    public static double inrToEuro(double inr) {
        return inr * INR_TO_EUR;
    }
}
