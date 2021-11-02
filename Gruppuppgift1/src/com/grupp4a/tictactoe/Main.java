package com.grupp4a.tictactoe;

import java.util.Random;
import java.util.Scanner;

import com.grupp4a.tictactoe.Player.PlayerMap;
import com.grupp4a.tictactoe.Player.Symbol;

public class Main {
	
	public static Player player = new Player();
	////
	public static int currentBestOf;
	public static int decidedBestOf;
	public static PlayerMap selectedPlayer;
	static Board board;

	public static void main(String[] args) {		
		StartMenu.startMenu();
	}
	public static void initializeGame() {
		Scanner scanner = new Scanner(System.in);
		// TODO Fel-hantering.
		// TODO skapa en snyggare Menu �n detta.
		// TODO fundering.. Att v�lja s� man kan spela mot en 'Dator' ocks�?
		
		board = new Board();
		
		System.out.println("V�lkommen till TicTacToe skapat av Grupp-4A.");
		System.out.println("V�nligen ange namn p� Spelare 1: ");
		String playerNameA = scanner.nextLine();
		System.out.println("V�nligen ange namn p� Spelare 2: ");
		String playerNameB = scanner.nextLine();
		
		addPlayers(playerNameA, playerNameB);
		PlayerMap playerOne = player.getPlayers().get(0);
		PlayerMap playerTwo = player.getPlayers().get(1);
		
		System.out.println("V�nligen ange 'B�st av': ");
		decidedBestOf = scanner.nextInt();
		
		System.out.println("---TicTacToe b�st av: " + decidedBestOf + " (" + playerOne.getName() + " vs " + playerTwo.getName() + ")---");
		
		// Spelaren med symbol X ska starta
		if(playerOne.getSymbol() == Player.Symbol.X) {
			selectedPlayer = playerOne;
			System.out.println("Spelare: " + playerOne.getName() + " - startar spelet med X!");
		} else if(playerTwo.getSymbol() == Player.Symbol.X) {
			selectedPlayer = playerTwo;
			System.out.println("Spelare: " + playerTwo.getName() + " - startar spelet med X!");
		}
		currentBestOf++;
		System.out.println("---Runda " + currentBestOf + "---");
		
		board.printBoard(board);
	}
	
	public static void runGame(Scanner scanner) {
		board.addPlayerMove(board, selectedPlayer);
		board.printBoard(board);
		board.checkWinner(selectedPlayer);
		
	}
	
	private static void addPlayers(String playerA, String playerB) {
		Symbol randomSymbol = Symbol.values()[new Random().nextInt(Symbol.values().length)];
		
		// Spelare 1 blir tilldelad en random Symbol (X/O).
		player.addPlayer(playerA, randomSymbol);
		
		// Spelare 2 blir tilldelad den Symbol som blir �ver.
		if(randomSymbol == Player.Symbol.X) {
			player.addPlayer(playerB, Player.Symbol.O);
		} else if(randomSymbol == Player.Symbol.O) {
			player.addPlayer(playerB, Player.Symbol.X);
		}
	}
	
	public static boolean endGame() {
		// Returnerar ifall vi ska avsluta spelet?
		if(currentBestOf > decidedBestOf) {
			return true;
		}
		return false;
	}
}