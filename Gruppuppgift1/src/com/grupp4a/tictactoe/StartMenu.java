package com.grupp4a.tictactoe;

import java.io.*;
import java.util.Scanner;


public class StartMenu {

	public static void startMenu() {

		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"    Tic Tac Toe \n[1] Player VS Player \n[2] Player VS Computer " + "\n[3] How to play \n[4] End");

		int answer = scanner.nextInt();

		switch (answer) {

		case 1:
			Main.initializeGame(scanner);
			break;
		// case 2: PlayerVSComputer; break;
		case 3:
			howToPlay(scanner);
			break;
		case 4:
			System.out.println("Game is closed");
			break;
		default:
			System.out.println("Not a valid answer");
			break;

		}
		scanner.close();
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
				//System.out.println();

			}
			rules.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! \nCouldn't find the rules");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error!!!!");
			e.printStackTrace();
		}
	
		backToMenu(scanner);
	}

	private static void backToMenu(Scanner scanner) {
		System.out.println(" Back to [M]enu? \n [Press M + Enter]");
			
		String answer = scanner.next().toLowerCase();
		
		//Loopar så att man kan skriva in fel 10gånger
		for (int i = 0; i<=10; i++) {
		if(answer.equals("m")) {
			
			StartMenu.startMenu();
		}
		else {
			System.out.println(" Not a valid answer");
		}
		 	answer = scanner.next().toLowerCase();

		}
	}

}
