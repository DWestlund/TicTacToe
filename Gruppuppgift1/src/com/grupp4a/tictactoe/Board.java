package com.grupp4a.tictactoe;

import java.util.HashSet;
import java.util.Scanner;

import com.grupp4a.tictactoe.Player.PlayerMap;

public class Board {
	private char[][] boardArray = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
	private HashSet<Character> playedSquares = new HashSet<Character>();

	public char[][] getBoardArray() {
		return boardArray;
	}

	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}

	public HashSet<Character> getPlayedSquares() {
		return playedSquares;
	}

	public boolean setPlayedSquares(HashSet<Character> playedSquares, int squareNr) {
		boolean added = this.playedSquares.add((char) (squareNr + '0'));

		return added;
	}

	public void printBoard(Board board) {
		for (int row = 0; row < board.boardArray.length; row++) {
			for (int col = 0; col < board.boardArray[row].length; col++) {
				System.out.print((col != 0) ? " | " + board.boardArray[row][col] : "  " + board.boardArray[row][col]);
			}
			System.out.println((row != 2) ? "\n -----------" : "");
		}
	}

	// Metod som anropas när en spelares drag ska läggas till
	public boolean addPlayerMove(Board board, PlayerMap selectedPlayer) {
		boolean moveOK = false;// Måste vara true genom hela metoden för att draget ska accepteras
		
		int squareNr = getPlayerInput();//User input

		moveOK = checkInputInRange(squareNr);// input 1-9

		if (moveOK == true) {
			moveOK = board.setPlayedSquares(playedSquares, squareNr);// Testar lägga till i HashSet
			if (moveOK == true) {
				int[] playedIndex = toBoardArrayIndex(squareNr);// Konv till boardArrIndex
				char playerSymbol = (selectedPlayer.getSymbol() == Player.Symbol.X) ? 'X' : 'O';// Hämtar spelarens symbol

				char[][] updBoardArray = board.getBoardArray();
				updBoardArray[playedIndex[0]][playedIndex[1]] = playerSymbol;// Lägger till spelarens symbol i
																				// tillfällig boardArr
				board.setBoardArray(updBoardArray);// Uppdaterar boardArray
				
				
				PlayerMap playerA = Main.player.getPlayers().get(0);
                PlayerMap playerB = Main.player.getPlayers().get(1);

                if(Main.selectedPlayer.equals(playerA)) {
                    Main.selectedPlayer = playerB;
                } else if(Main.selectedPlayer.equals(playerB)) {
                    Main.selectedPlayer = playerA;
                }
							
			} else {
				System.out.println("Rutan är redan spelad...");
			}
		} else {
			System.out.println("Spelplanen är mellan 1-9...");
		}
		return moveOK;
	}

	private int getPlayerInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ditt nummer:");
		int usrIn = scanner.nextInt();
		
		return usrIn;
	}

	// Metod som konverterar players input (1-9) till plats i boardArray
	public int[] toBoardArrayIndex(int squareNr) {
		int[] boardIndex = new int[2];

		// Vilken rad input ska hamna i
		if (squareNr <= 3) {
			boardIndex[0] = 0;
		} else if (squareNr <= 6) {
			boardIndex[0] = 1;
		} else {
			boardIndex[0] = 2;
		}

		// Vilken kolumn input ska hamna i
		if (squareNr == 1 || squareNr == 4 || squareNr == 7) {
			boardIndex[1] = 0;
		} else if (squareNr == 2 || squareNr == 5 || squareNr == 8) {
			boardIndex[1] = 1;
		} else {
			boardIndex[1] = 2;
		}
		return boardIndex;
	}

	// Kollar om spelaren har angett 1-9
	public boolean checkInputInRange(int squareNr) {
		boolean inRange;

		if (squareNr >= 1 && squareNr <= 9) {
			inRange = true;
		} else {
			inRange = false;
		}

		return inRange;
	}

	// TODO Metod som kollar om spelaren har vunnit
	public PlayerMap checkWinner(PlayerMap player) {

		if (boardArray[0][0] == 'X' && boardArray[0][1] == 'X' && boardArray[0][2] == 'X') {// Kollar om symbolen finns
																							// horizontellt
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[0][0] == 'O' && boardArray[0][1] == 'O' && boardArray[0][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[1][0] == 'X' && boardArray[1][1] == 'X' && boardArray[1][2] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[1][0] == 'O' && boardArray[1][1] == 'O' && boardArray[1][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[2][0] == 'X' && boardArray[2][1] == 'X' && boardArray[2][2] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[2][0] == 'O' && boardArray[2][1] == 'O' && boardArray[2][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[0][0] == 'X' && boardArray[1][0] == 'X' && boardArray[2][0] == 'X') {// Kollar om symbolen finns
																							// vertikalt
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[0][0] == 'O' && boardArray[1][0] == 'O' && boardArray[2][0] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[0][1] == 'X' && boardArray[1][1] == 'X' && boardArray[2][1] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[0][1] == 'O' && boardArray[1][1] == 'O' && boardArray[2][1] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[0][2] == 'X' && boardArray[1][2] == 'X' && boardArray[2][2] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[0][2] == 'O' && boardArray[1][2] == 'O' && boardArray[2][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[0][0] == 'X' && boardArray[1][1] == 'X' && boardArray[2][2] == 'X') {// Kollar om symbolen finns
																							// diagonalt
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[0][0] == 'O' && boardArray[1][1] == 'O' && boardArray[2][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[2][0] == 'X' && boardArray[2][1] == 'X' && boardArray[0][2] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[1][0] == 'O' && boardArray[1][1] == 'O' && boardArray[1][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
		}
		if (boardArray[2][0] == 'X' && boardArray[1][1] == 'X' && boardArray[2][2] == 'X') {
			System.out.println("Spelare" + Player.Symbol.X + " vinner.");
		}
		if (boardArray[2][0] == 'O' && boardArray[1][1] == 'O' && boardArray[2][2] == 'O') {
			System.out.println("Spelare" + Player.Symbol.O + " vinner.");
			// TODO kontrolera sant/falskt, oavgjort samt poängräknare
		}		
		return player;// Behövs det läggas till en boolean winner i PlayerMap? Isf kan man sätta den
		// till true om den vunnit
	}
}
