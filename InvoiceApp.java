import java.util.Scanner;

/*
 * Description: Invoice App that calculated invoice discounts
 * Programmer Adah Heng
 * Date Written 1-27-2023
 * GitHub https://github.com/Adah-Heng/Java-projects.git
 */

public class InvoiceApp {

	public static void main(String[] args) {

		// create a Scanner object named sc
		Scanner sc = new Scanner(System.in);
		// initialize variables for use in calculating averages
		int invoiceCount = 0;
		int numLineItems = 0;
		double discountAverage = 0.0;
		double invoiceTotal = 0.0;
		double discountTotal = 0.0;
		double subtotal = 0.0;
		double discountPercent = 0.0;
		double discountAmount = 0.0;
		double discountedInvoiceTotal = 0.0;
		double averageInvoice = 0.0;
		String choice = "y";

		// welcome the user to the program
		System.out.println("============================================");
		System.out.println("Welcome to the Invoice Total Calculator v5");
		System.out.println("============================================");
		System.out.println(); // print a blank line

		// perform invoice calculations until choice is "n" or "N"
		while (!choice.equalsIgnoreCase("n")) {

			// get the invoice get number of line items from the user
			System.out.print("Enter the number of line items: ");
			numLineItems = sc.nextInt();
			System.out.println("============================================");
			
			// get invoice line item amounts form user
			for (int i = 1; i <= numLineItems; i++) {
				System.out.println(); // to leave space
				System.out.print("Enter #" + i + " the line item amount: ");
				subtotal += sc.nextDouble();
			}

			// calculate the discount amount and total
			if (subtotal >= 500) {
				discountPercent = 0.25;
			} else if (subtotal >= 200) {
				discountPercent = 0.2;
			} else if (subtotal >= 100) {
				discountPercent = 0.1;
			} else {
				discountPercent = 0.0;
			}
			discountAmount = subtotal * discountPercent;
			discountedInvoiceTotal = subtotal - discountAmount;

			// accumulate the invoice count and invoice total
			invoiceTotal = invoiceTotal + discountedInvoiceTotal;
			discountTotal = discountTotal + discountAmount;
			invoiceCount++;

			System.out.print("============================================");
			sc.nextLine();
			// display the subtotal

			System.out.println();
			System.out.printf("%20s: %,10.2f\n", "Subtotal", subtotal);
			System.out.printf("%20s: %,10.2f\n", "Discount Percent", discountPercent);
			System.out.printf("%20s: %,10.2f\n", "Discount Amount", discountAmount);
			sc.nextLine();
			System.out.println();
			System.out.println("============================================");

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println("============================================");
		} // end of while loop

		averageInvoice = invoiceTotal / invoiceCount;
		discountAverage = discountTotal / invoiceCount;

		// calculate and display invoice count, average invoice, and average discount
		System.out.printf("%20s: %,10d\n", "Invoice count", invoiceCount);
		System.out.printf("%20s: %,10.2f\n", "Average invoice", averageInvoice);
		System.out.printf("%20s: %,10.2f\n", "Average discount", discountAverage);
		sc.nextLine();
		System.out.println("============================================");

		sc.close();
	}// end of main
}// class
