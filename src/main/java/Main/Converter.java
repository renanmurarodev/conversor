package Main;


import ConverterAPI.Conversor;
import Model.Interaction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		Interaction text = new Interaction();

		History history = new History(reader);
		Conversor conversor = new Conversor(history);

		var key = 0;

		while (key != 8) {
			text.textMain();
			key = text.Check(reader);

			double finaL = 0;
			if (key != 7 && key != 8) {
				try {
					System.out.println("\nQual o valor que deseja converter?");
					finaL = reader.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, tente novamente!\n\n");
					reader.nextLine();
					continue;
				}
			}

			switch (key) {

				case 1:
					conversor.Conv("BRL", "USD", finaL);
					break;
				case 2:
					conversor.Conv("USD", "BRL", finaL);
					break;
				case 3:
					conversor.Conv("BRL", "EUR", finaL);
					break;
				case 4:
					conversor.Conv("EUR", "BRL", finaL);
					break;
				case 5:
					conversor.Conv("BRL", "AUD", finaL);
					break;
				case 6:
					conversor.Conv("AUD", "BRL", finaL);
					break;


				case 7:
					history.TestHistory();
					break;
				case 8:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}
		reader.close();
	}
}
