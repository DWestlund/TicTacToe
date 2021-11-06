package com.grupp4a.tictactoe;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Computer {

	public static int computerNr(HashSet<Character> playedSquares) {

		String playedNr = playedSquares.toString(); // Gör om hashset till String

		Random random = new Random();
		int compNummer = random.nextInt(8) + 1;
		String compNr = String.valueOf(compNummer); // Skapar ett random nr mellan 1-9 och gör om till string

		boolean find = find(playedNr, compNr);

		while (find == true) { // Om rutan inte är ledig genereras ett nytt random nummer

			random = new Random();

			compNummer = random.nextInt(8) + 1;
			compNr = String.valueOf(compNummer);

			find = find(playedNr, compNr);
		}

		try {
			TimeUnit.MILLISECONDS.sleep(30); // Gör så att datorn inte gör sitt drag super snabbt
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Datorn väljer att lägga på " + compNr);

		return compNummer;

	}

	public static boolean find(String playedNr, String compNr) { // Kollar så att rutan datorn vill välja är ledig

		if (playedNr.contains(compNr)) {

			return true;
		} else {
			return false;
		}

	}
}
