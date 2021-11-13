package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = scn.nextInt();
			System.out.print("Holder: ");
			String holder = scn.nextLine();
			System.out.print("Initial balance: ");
			Double balance = scn.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withdrawLimit = scn.nextDouble();

			Account acc = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = scn.nextDouble();
			acc.withdraw(amount);
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e);
		}

		scn.close();
	}

}
