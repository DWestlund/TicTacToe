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
		// TODO skapa en snyggare Menu än detta.
		// TODO fundering.. Att välja så man kan spela mot en 'Dator' också?
		
		board = newGameBoard();
		
		System.out.println("Välkommen till TicTacToe skapat av Grupp-4A.");
		System.out.println("Vänligen ange namn på Spelare 1: ");
		String playerNameA = scanner.nextLine();
		System.out.println("Vänligen ange namn på Spelare 2: ");
		String playerNameB = scanner.nextLine();
		
		addPlayers(playerNameA, playerNameB);
		PlayerMap playerOne = player.getPlayers().get(0);
		PlayerMap playerTwo = player.getPlayers().get(1);
		
		System.out.println("Vänligen ange 'Bäst av': ");
		decidedBestOf = scanner.nextInt();
		
		System.out.println("---TicTacToe bäst av: " + decidedBestOf + " (" + playerOne.getName() + " vs " + playerTwo.getName() + ")---");
		
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
	
	public static Board newGameBoard() {
		Board board = new Board();	
		return board;
	}
	
	public static void runGame(Scanner scanner) {		
		do {
			PlayerMap winner = board.checkWinner(selectedPlayer);
			if(winner == null) {
				board.addPlayerMove(board, selectedPlayer);
				board.printBoard(board);
				setNewPlayerTurn();
			} else {
				System.out.println(winner.getName() + " är vinnare!\n");
				winner.setScore(winner.getScore() + 1);
				
				PlayerMap playerOne = player.getPlayers().get(0);
				PlayerMap playerTwo = player.getPlayers().get(1);
				
				currentBestOf++;
				
				System.out.println( "Score:\n" + playerOne.getName() + "| " + playerOne.getScore() + "  -  " + playerTwo.getScore() + " |" + playerTwo.getName());
				System.out.println("\nRunda: " + currentBestOf + " av " + decidedBestOf + "\n");
				
				
				board = newGameBoard();
				board.printBoard(board);
			}		
		} while(!Main.endGame());
	}
	
	private static void setNewPlayerTurn() {
		PlayerMap playerA = player.getPlayers().get(0);
        PlayerMap playerB = player.getPlayers().get(1);

        if(selectedPlayer.equals(playerA)) {
            selectedPlayer = playerB;
        } else if(selectedPlayer.equals(playerB)) {
            selectedPlayer = playerA;
        }
	}
	
	private static void addPlayers(String playerA, String playerB) {
		Symbol randomSymbol = Symbol.values()[new Random().nextInt(Symbol.values().length)];
		
		// Spelare 1 blir tilldelad en random Symbol (X/O).
		player.addPlayer(playerA, randomSymbol);
		
		// Spelare 2 blir tilldelad den Symbol som blir över.
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