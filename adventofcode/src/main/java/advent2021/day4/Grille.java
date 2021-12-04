package advent2021.day4;

import java.util.List;

public class Grille {

	private static int TAILLE_ROW = 5;
	private static int TAILLE_COL = 5;

	int[][] grille = new int[TAILLE_ROW][TAILLE_COL];
	public boolean isGagnate = false;

	public Grille(int[][] grille) {
		this.grille = grille;
		this.isGagnate = false;
	}

	public int isBingo(List<Integer> numeros) {
		int valeurBingo = 0;

		int[] nbNumero = checkLigne(numeros);
		if (nbNumero[0] != 5) {
			nbNumero = checkColonnes(numeros);
			if (nbNumero[0] == 5) {
				valeurBingo = numeros.get(numeros.size() - 1) * getTotalGrille(numeros);
				isGagnate = true;
			}
		} else {
			valeurBingo = numeros.get(numeros.size() - 1) * getTotalGrille(numeros);
			isGagnate = true;
		}
		return valeurBingo;
	}

	private int[] checkLigne(List<Integer> numeros) {
		int nbNumero = 0;
		int index = 0;
		for (int row = 0; row < TAILLE_ROW; row++) {
			for (int col = 0; col < TAILLE_COL; col++) {
				if (numeros.contains(grille[row][col])) {
					nbNumero++;
				}
			}
			if (nbNumero != 5) {
				nbNumero = 0;
			} else {
				index = row + 1;
				break;
			}
		}
		return new int[] { nbNumero, index };
	}

	private int[] checkColonnes(List<Integer> numeros) {
		int nbNumero = 0;
		int index = 0;
		for (int col = 0; col < TAILLE_COL; col++) {
			for (int row = 0; row < TAILLE_ROW; row++) {
				if (numeros.contains(grille[row][col])) {
					nbNumero++;
				}
			}
			if (nbNumero != 5) {
				nbNumero = 0;
			} else {
				index = col + 1;
				break;
			}
		}
		return new int[] { nbNumero, index };
	}

	private int getTotalGrille(List<Integer> numeros) {
		int somme = 0;
		for (int col = 0; col < TAILLE_COL; col++) {
			for (int row = 0; row < TAILLE_ROW; row++) {
				if (!numeros.contains(grille[row][col])) {
					somme += grille[row][col];
				}
			}
		}
		return somme;
	}

	public boolean isGagnate() {
		return isGagnate;
	}

}
