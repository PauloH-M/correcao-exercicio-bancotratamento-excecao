package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) throws DomainException{

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer numberAcc = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holderAcc = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialAcc = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			Account acc = new Account(numberAcc, holderAcc, initialAcc, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
		  	acc.withdraw(sc.nextDouble());
		    System.out.printf("New balance: %.2f ", acc.getBalance());
		}
	       
        catch (DomainException e) {
        	System.out.println("Withdraw error: "+ e.getMessage());
        }
		catch(RuntimeException e) {
			System.out.println("Algo de errado nao esta certo");
		}
		
		sc.close();
	}
}