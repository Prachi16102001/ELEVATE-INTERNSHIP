import java.util.Scanner;

public class  Task3 {
    // Exchange rates as constants
    public static final double USD_TO_EUR = 0.91;
    public static final double EUR_TO_USD = 1.10;
    public static final double USD_TO_GBP = 0.77;
    public static final double GBP_TO_USD = 1.30;
    public static final double EUR_TO_GBP = 0.85;
    public static final double GBP_TO_EUR = 1.17;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter the amount to convert: ");
        double amount = getValidAmount(scanner);

        System.out.print("Enter the source currency (USD, EUR, GBP): ");
        String fromCurrency = getValidCurrency(scanner);

        System.out.print("Enter the target currency (USD, EUR, GBP): ");
        String toCurrency = getValidCurrency(scanner);

        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        if (convertedAmount == -1) {
            System.out.println("Invalid currency conversion.");
        } else {
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, toCurrency);
        }

        scanner.close();
    }

    public static double getValidAmount(Scanner scanner) {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    throw new NumberFormatException();
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Please enter a positive number: ");
            }
        }
    }

    public static String getValidCurrency(Scanner scanner) {
        while (true) {
            String currency = scanner.nextLine().toUpperCase();
            if (currency.equals("USD") || currency.equals("EUR") || currency.equals("GBP")) {
                return currency;
            } else {
                System.out.print("Invalid currency. Please enter USD, EUR, or GBP: ");
            }
        }
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        switch (fromCurrency + "->" + toCurrency) {
            case "USD->EUR":
                return amount * USD_TO_EUR;
            case "EUR->USD":
                return amount * EUR_TO_USD;
            case "USD->GBP":
                return amount * USD_TO_GBP;
            case "GBP->USD":
                return amount * GBP_TO_USD;
            case "EUR->GBP":
                return amount * EUR_TO_GBP;
            case "GBP->EUR":
                return amount * GBP_TO_EUR;
            default:
                return -1; // Invalid conversion
        }
    }
}