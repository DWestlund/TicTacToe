package com.grupp4a.tictactoe;

import com.grupp4a.tictactoe.Player.PlayerMap;

public class Board {
	
	private char[][] boardArray = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
	
	public char[][] getBoardArray() {
		return boardArray;
	}
	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}
	
	
	private void editBoard(Board board) {
		board.boardArray[0][0] = 'X';
	}
		
	private void printBoard(Board board) {
		System.out.println("  Spelplan");
		for(int row = 0; row < board.boardArray.length; row++) {		
			for(int col = 0; col < board.boardArray[row].length; col++) {			
				System.out.print((col != 0) ? " | " + board.boardArray[row][col] : "  " + board.boardArray[row][col]);			
			}					
			System.out.println((row != 2) ? "\n -----------" : "");
		}		
	}
	
	//Metod som konverterar players input (1-9) till plats i boardArray 
	public void convertInputToArrayIndex(int placeSquare, PlayerMap player) {
		
	}
	
	//TODO Metod som kollar om rutan där spelaren vill lägga är tom
	public void denyConfirmPlacedSymbol(PlayerMap player) {
		//Om ruta är ledig, anropa updateBoardArray
	}
	
	//TODO Metod som lägger in spelarens symbol i boardArray
	private void updateBoardArray(PlayerMap player) {
		
	}
	
	//TODO Metod som kollar om spelaren har vunnit
	public PlayerMap checkWinner(PlayerMap player, Player.Symbol symbol) {
			
		//TODO kolla om symbolen finns horizontally, vertically eller across (Olika metoder?)
		
		return player;//Behövs det läggas till en boolean winner i PlayerMap? Isf kan man sätta den till true om den vunnit
	}
	
	
}
