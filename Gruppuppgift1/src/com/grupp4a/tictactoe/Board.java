package com.grupp4a.tictactoe;


public class Board {
	
	private char[][] boardArray = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
	
	public char[][] getBoardArray() {
		return boardArray;
	}
	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}
	
	public static void main (String[] args) {
		Board board = new Board();		
//		board.editBoard(board);
		
		board.printBoard(board);
		
		board.printBoard2(board);
		
		board.printBoard3(board);
	}
	
	
	private void editBoard(Board board) {
		board.boardArray[0][0] = 'X';
	}
	
	
	private void printBoard(Board board) {
		System.out.println();
		
		System.out.println(" -------------");		
		for(int row = 0; row < board.boardArray.length; row++) {
			
			for(int col = 0; col < board.boardArray[row].length; col++) {
				System.out.print(" | " + board.boardArray[row][col]);
			}		
			System.out.println(" |");
			System.out.println(" -------------");
		}		
	}
	
	private void printBoard2(Board board) {
		System.out.println();
		
		for(int row = 0; row < board.boardArray.length; row++) {
			
			for(int col = 0; col < board.boardArray[row].length; col++) {
				System.out.print(" | " + board.boardArray[row][col]);
			}		
			System.out.println(" |");			
			System.out.println((row != 2) ? " -------------" : "");
		}
		
	}
	
	
	
	
	private void printBoard3(Board board) {
		for(int row = 0; row < board.boardArray.length; row++) {		
			for(int col = 0; col < board.boardArray[row].length; col++) {			
				System.out.print((col != 0) ? " | " + board.boardArray[row][col] : "  " + board.boardArray[row][col]);			
			}					
			System.out.println((row != 2) ? "\n -----------" : "");
		}		
	}
	
	
	



	
}
