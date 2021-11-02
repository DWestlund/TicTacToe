package com.grupp4a.tictactoe;

import java.util.ArrayList;

public class Player {
	
	// Listan som innehåller spelarna.
	public ArrayList<PlayerMap> players = new ArrayList<>();

	public enum Symbol {
		X, O;
	}
	
	public class PlayerMap {
		private String name;
		private Symbol symbol;
		private int score;
		
		public PlayerMap(String name, Symbol symbol) {
			this.name = name;
			this.setSymbol(symbol);
			this.setScore(0);
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Symbol getSymbol() {
			return symbol;
		}

		public void setSymbol(Symbol symbol) {
			this.symbol = symbol;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
	}
	
	public void addPlayer(String name, Symbol symbol) {
		players.add(new PlayerMap(name, symbol));
	}
	
	public ArrayList<PlayerMap> getPlayers() {
		return players;
	}
}
