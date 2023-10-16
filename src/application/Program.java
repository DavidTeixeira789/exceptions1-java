package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Número do quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Data check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
				Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
	
				System.out.println();
				System.out.println("Atualização: ");
	
				System.out.print("Data check-in (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Data check-out (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
	
				reserva.atualizacao(checkIn, checkOut);
				System.out.print("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data inválida");
		}
		catch(DominioExceptions e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

}
