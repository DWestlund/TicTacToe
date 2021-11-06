package com.grupp4a.tictactoe;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.grupp4a.tictactoe.Player.PlayerMap;
import com.grupp4a.tictactoe.Player.Symbol;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static Player player = new Player();
	public static int currentBestOf;
	public static int decidedBestOf;
	public static PlayerMap selectedPlayer;
	static GameBoard board;

	public static void main(String[] args) {
		StartMenu.startMenu();
	}

	public static void initializeGame(boolean computer) {
		// TODO Fel-hantering.
		// TODO skapa en snyggare Menu än detta.
		// TODO fundering.. Att välja så man kan spela mot en 'Dator' också?

		board = newGameBoard();

		System.out.println("Välkommen till TicTacToe skapat av Grupp-4A.");
		System.out.print("Vänligen ange namn på Spelare 1: ");
		String playerNameA = scanner.nextLine();
		String playerNameB = null;
		if (computer == true) {

			playerNameB = "Computer";
		} else if (computer == false) {
			System.out.print("Vänligen ange namn på Spelare 2: ");
			playerNameB = scanner.nextLine();
		}

		addPlayers(playerNameA, playerNameB);
		PlayerMap playerOne = player.getPlayers().get(0);
		PlayerMap playerTwo = player.getPlayers().get(1);

		System.out.print("Vänligen ange 'Bäst av': ");
		decidedBestOf = scanner.nextInt();

		System.out.println("\n---TicTacToe bäst av: " + decidedBestOf + " (" + playerOne.getName() + " vs "
				+ playerTwo.getName() + ")---");

		// Spelaren med symbol X ska starta
		if (playerOne.getSymbol() == Player.Symbol.X) {
			selectedPlayer = playerOne;
			System.out.println("Spelare: " + playerOne.getName() + " - startar spelet med X!");
		} else if (playerTwo.getSymbol() == Player.Symbol.X) {
			selectedPlayer = playerTwo;
			System.out.println("Spelare: " + playerTwo.getName() + " - startar spelet med X!");
		}
		currentBestOf++;
		System.out.println("---Runda " + currentBestOf + "---");

		board.printBoard(board);
	}

	public static GameBoard newGameBoard() {
		GameBoard board = new GameBoard();
		return board;
	}

	public static void runGame(Scanner scanner) {
		PlayerMap winner = null;
		PlayerMap playerOne = player.getPlayers().get(0);
		PlayerMap playerTwo = player.getPlayers().get(1);
		do {

			if (winner == null) {
				boolean moveOK = board.addPlayerMove(board, selectedPlayer);
				board.printBoard(board);
				if (moveOK)
					winner = board.checkWinner(selectedPlayer);

				setNewPlayerTurn();
			} else if (currentBestOf < decidedBestOf) {
				System.out.println(winner.getName() + " är vinnare!\n");
				winner.setScore(winner.getScore() + 1);

				currentBestOf++;

				System.out.println("Poäng:\n" + playerOne.getName() + "| " + playerOne.getScore() + "  -  "
						+ playerTwo.getScore() + " |" + playerTwo.getName());

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("\nRunda: " + currentBestOf + " av " + decidedBestOf + "\n");
				winner = null;

				board = newGameBoard();
				board.printBoard(board);
			}

			else {
				winner.setScore(winner.getScore() + 1);
				System.out.println("Poäng:\n" + playerOne.getName() + "| " + playerOne.getScore() + "  -  "
						+ playerTwo.getScore() + " |" + playerTwo.getName());
				System.out.println("-----------------");
				if (playerOne.getScore() < playerTwo.getScore()) {

					System.out.println("\nVinnaren är " + playerTwo.getName() + "!!!");
					break;
				} else if (playerOne.getScore() > playerTwo.getScore()) {

					System.out.println("\nVinnaren är " + playerOne.getName() + "!!!");
					break;
				} else if (playerOne.getScore() == playerTwo.getScore()) {

					System.out.println("\nDet blev oavgjort!");
					winner = null;
					break;
				}
			}
		} while (!Main.endGame());

		System.out.println("\nSpelet avslutat\n");
		StartMenu.backToMenu(scanner);
	}

	static void setNewPlayerTurn() {
		PlayerMap playerA = player.getPlayers().get(0);
		PlayerMap playerB = player.getPlayers().get(1);

		if (selectedPlayer.equals(playerA)) {
			selectedPlayer = playerB;
		} else if (selectedPlayer.equals(playerB)) {
			selectedPlayer = playerA;
		}
	}

	static void addPlayers(String playerA, String playerB) {
		Symbol randomSymbol = Symbol.values()[new Random().nextInt(Symbol.values().length)];

		// Spelare 1 blir tilldelad en random Symbol (X/O).
		player.addPlayer(playerA, randomSymbol);

		// Spelare 2 blir tilldelad den Symbol som blir över.
		if (randomSymbol == Player.Symbol.X) {
			player.addPlayer(playerB, Player.Symbol.O);
		} else if (randomSymbol == Player.Symbol.O) {
			player.addPlayer(playerB, Player.Symbol.X);
		}
	}

	public static boolean endGame() {
		// Returnerar ifall vi ska avsluta spelet?
		if (currentBestOf > decidedBestOf) {
			return true;
		}
		return false;
	}
}