package com.grupp4a.tictactoe;

import java.util.HashSet;

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

	// Metod som anropas n�r en spelares drag ska l�ggas till
	public boolean addPlayerMove(int squareNr, PlayerMap player, Board board) {
		boolean moveOK = false;// M�ste vara true genom hela metoden f�r att draget ska accepteras

		moveOK = checkInputInRange(squareNr);// input 1-9

		if (moveOK == true) {
			moveOK = board.setPlayedSquares(playedSquares, squareNr);// Testar l�gga till i HashSet
			if (moveOK == true) {
				int[] playedIndex = toBoardArrayIndex(squareNr);// Konv till boardArrIndex
				char playerSymbol = (player.getSymbol() == Player.Symbol.X) ? 'X' : 'O';// H�mtar spelarens symbol

				char[][] updBoardArray = board.getBoardArray();
				updBoardArray[playedIndex[0]][playedIndex[1]] = playerSymbol;// L�gger till spelarens symbol i
																				// tillf�llig boardArr

				board.setBoardArray(updBoardArray);// Uppdaterar boardArray
			} else {
				System.out.println("Rutan �r redan spelad...");
			}
		} else {
			System.out.println("Spelplanen �r mellan 1-9...");
		}
		return moveOK;
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
	public PlayerMap checkWinner(PlayerMap player, Player.Symbol symbol) {

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
			// TODO kontrolera sant/falskt, oavgjort samt po�ngr�knare
		}		
		return player;// Beh�vs det l�ggas till en boolean winner i PlayerMap? Isf kan man s�tta den
		// till true om den vunnit
	}
}
