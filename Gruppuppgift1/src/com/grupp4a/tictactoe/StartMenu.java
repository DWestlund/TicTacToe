package com.grupp4a.tictactoe;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartMenu {

	public static void startMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean computer = false;

		while (true) {
			System.out.print("    Tic Tac Toe \n" + "[1] Spelare VS Spelare" + "\n[2] Spelare VS Dator "
					+ "\n[3] Läs regelbok" + "\n[4] Avsluta program\n>>> ");
			try {
				int answer = scanner.nextInt();

				switch (answer) {

				case 1:
					Main.initializeGame(computer);
					Main.runGame(scanner);
					break;
				case 2:
					computer = true;
					Main.initializeGame(computer);
					Main.runGame(scanner);
					break;
				case 3:
					howToPlay(scanner);
					break;
				case 4:
					System.out.println("Avslutar Programmet...");
					System.exit(0);
					break;
				default:
					System.out.println("Välj ett val ur menyn...");
					scanner.nextInt();
					break;

				}
				scanner.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Menyn besår endast av siffror...\n");
				scanner.nextLine();
			}
		}

	}

	private static void howToPlay(Scanner scanner) {

		// Läser från textfil med spelreglerna
		try {
			FileReader fil = new FileReader("TicTacToeRules.txt");

			var rules = new BufferedReader(fil);

			while (true) {

				String row = rules.readLine();

				if (row == null) {
					break;
				}

				System.out.println(row);

			}
			rules.close();
		} catch (FileNotFoundException e) {
			System.out.println("Kunde inte hitta regelboken");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error!!!!");
			e.printStackTrace();
		}
		backToMenu(scanner);
	}

	static void backToMenu(Scanner scanner) {
		System.out.println(" Tillbaka till [M]enyn? \n [Tryck M + Enter]");

		String answer = scanner.next().toLowerCase();

		// Loopar så att man kan skriva in fel 10gånger
		for (int i = 0; i <= 10; i++) {
			if (answer.equals("m")) {
				StartMenu.startMenu();
			} else {
				System.out.println(" Inte ett giltigt svar");
			}
			answer = scanner.next().toLowerCase();

		}
	}

}
