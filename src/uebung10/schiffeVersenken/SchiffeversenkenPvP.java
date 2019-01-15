package uebung10.schiffeVersenken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchiffeversenkenPvP {
	
	Player player1;
	Player player2;
	
	private static Scanner scanner = new Scanner(System.in);
	
	int gro�e;
	
	public static SchiffeversenkenPvP startGame(String namePlayer1, String namePlayer2, int gro�e) {
		
		SchiffeversenkenPvP schiffeversenkenPvP = new SchiffeversenkenPvP();
		schiffeversenkenPvP.generateGrid(namePlayer1, namePlayer2, gro�e + 1);
		
		return schiffeversenkenPvP;
	}

	private void generateGrid(String namePlayer1, String namePlayer2, int gro�e) {
		
		this.player1 = new Player(namePlayer1);		
		this.player2 = new Player(namePlayer2);
		
		player1.setAndererPlayer(player2);
		player2.setAndererPlayer(player1);
		
		this.gro�e = gro�e;
		
		List<String[][]> spielFelder = new ArrayList<>();
		
		player1.setSpielfeld(new String[gro�e][gro�e]);
		player1.setSchlachtfeld((new String[gro�e][gro�e]));
		player2.setSpielfeld(new String[gro�e][gro�e]);
		player2.setSchlachtfeld((new String[gro�e][gro�e]));
		
		spielFelder.add(player1.getSpielfeld());
		spielFelder.add(player1.getSchlachtfeld());
		spielFelder.add(player2.getSpielfeld());
		spielFelder.add(player2.getSchlachtfeld());
		
		for (String [][] feld : spielFelder) {
			for (int i = 0; i < gro�e; i++) {
				for (int j = 0; j < gro�e; j++) {
					if (i == 0) {
						feld[i][j] = "" + j;
						continue;
					}
					if (j == 0) {
						if (i == gro�e - 1) {
							feld[i][j] = i + "";
							continue;
						}
						feld[i][j] = i + " ";
						continue;
					}
					feld[i][j] = " ";
				}
			}
		}
	}
	
	public void showGrid() {
		for (String[] i : player1.getSchlachtfeld()) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("----------------------------------");
		for (String[] i : player1.getSpielfeld()) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("----------------------------------");
		for (String[] i : player2.getSchlachtfeld()) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("----------------------------------");
		for (String[] i : player2.getSpielfeld()) {
			System.out.println(Arrays.toString(i));
		}
	}

	public void clearConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}

	public void warte() {
		System.out.println("Fertig(beliebiges Zeichen eingeben)?");
		scanner.next();
		System.out.println();
	}
}
