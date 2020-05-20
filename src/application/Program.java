package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.InvalidAmountException;
import model.exceptions.NotEnoughBalanceException;
import model.exceptions.WithdrawLimitException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(sc.nextDouble());
			sc.nextLine();
			System.out.print("New balance: " + account.getBalance());
			
		} catch (InvalidAmountException e) {
			System.out.println(e);
		} catch (NotEnoughBalanceException e) {
			System.out.println("Withdraw error: Not enough balance");
		} catch (WithdrawLimitException e) {
			System.out.println("Withdraw error: Amount exceds withdraw limit");
		} catch (RuntimeException e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
