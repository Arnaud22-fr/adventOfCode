package advent2021.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

//	static int[][] datas = Datas.getDataTest();
	static int[][] datas = Datas.getData();

	public static void main(String[] args) {

		List<Integer> results = new ArrayList<Integer>();

		for (int x = 0; x < datas.length; x++) {
			for (int y = 0; y < datas[0].length; y++) {
				if (datas[x][y] != 9 && datas[x][y] != -1) {
					System.out.println("nouveau chiffre x = " + x + ", y = " + y);
					results.add(setEntourrage(x, y, 0));
//					if (datas[x][y] < 9) {
//						datas[x][y] = -1;
//					}
				}
			}
		}

		Collections.sort(results, Collections.reverseOrder());

		System.out.println(results.get(0) * results.get(1) * results.get(2));
	}

	private static void afficher(int[][] datas2) {
		for (int x = 0; x < datas.length; x++) {
			String ligne = "";
			for (int y = 0; y < datas[0].length; y++) {
				ligne += "" + datas[x][y];
			}
			System.out.println(ligne);
		}
	}

	public static int setEntourrage(int xTab, int yTab, int total) {
		if (valideDonnee(xTab, yTab) && datas[xTab][yTab] != -1 && datas[xTab][yTab] != 9) {
			total++;
			datas[xTab][yTab] = -1;

			int chiffreBas = afficheDonnee(xTab + 1, yTab);
			if (chiffreBas != -1 && chiffreBas != 9) {
				total = setEntourrage(xTab + 1, yTab, total);
			}
			int chiffreHaut = afficheDonnee(xTab - 1, yTab);
			if (chiffreHaut != -1 && chiffreHaut != 9) {
				total = setEntourrage(xTab - 1, yTab, total);
			}
			int chiffreDroite = afficheDonnee(xTab, yTab + 1);
			if (chiffreDroite != -1 && chiffreDroite != 9) {
				total = setEntourrage(xTab, yTab + 1, total);
			}
			int chiffreGauche = afficheDonnee(xTab, yTab - 1);
			if (chiffreGauche != -1 && chiffreGauche != 9) {
				total = setEntourrage(xTab, yTab - 1, total);
			}
		}
		return total;
	}

	private static int afficheDonnee(int xTab, int yTab) {
		if (valideDonnee(xTab, yTab)) {
//			System.out.println(datas[xTab][yTab]);
			return datas[xTab][yTab];
		} else {
			return -1;
		}

	}

	// Verifier qu'on ne depasse pas le tableau (a ne pas oublier).
	private static boolean valideDonnee(int xTab, int yTab) {
		if (xTab < 0 || xTab >= datas.length)
			return false;
		return !(yTab < 0 || yTab >= datas[0].length);
	}

}
