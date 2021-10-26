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
			Main.endGame();
			break;
		default:
			System.out.println("Not a valid answer");
			break;

		}
		scanner.close();
	}

	private static void howToPlay(Scanner scanner) {
		
		//TODO Fixa while eller if för stt kunna gå tillbaka till startMenu
		
		//Läser från textfil med spelreglerna
		try {
			FileReader fil = new FileReader("TicTacToeRules.txt");

			var rules = new BufferedReader(fil);

			while (true) {

				String row = rules.readLine();

				if (row == null) {
					break;
				}

				System.out.println(row);
				System.out.println();

			}
			rules.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! \nCouldn't find the rules");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error!!!!");
			e.printStackTrace();
		}

		
		
		System.out.println("Back to menu? \nY/N");
		String answer = "n";
		answer = scanner.next().toLowerCase();

			if (answer == "y") {
				startMenu();
			}

//		if(answer == "y") {
//			startMenu();
//		}
//		else if(answer == "n") {
//			break;
//		}
//		else System.out.println("Not a valid answer");
	}

}
