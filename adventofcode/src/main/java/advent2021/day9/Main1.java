package advent2021.day9;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

//	static int[][] datas = Datas.getDataTest();
	static int[][] datas = Datas.getData();

	public static void main(String[] args) {
		List<Integer> results = new ArrayList<Integer>();

		for (int x = 0; x < datas.length; x++) {
			for (int y = 0; y < datas[0].length; y++) {
				System.out.println("nouveau chiffre x = " + x + ", y = " + y);
				List<Integer> entourrage = getEntourrage(x, y);
				int min = Integer.MAX_VALUE;
				for (int chiffre : entourrage) {
					if (chiffre < min) {
						min = chiffre;
					}
				}
				if (datas[x][y] < min) {
					results.add(datas[x][y]);
				}
			}
		}
		int total = 0;
		for (int result : results) {
			total += result;
		}
		System.out.println(total + results.size());
	}

	public static List<Integer> getEntourrage(int xTab, int yTab) {
		List<Integer> chiffres = new ArrayList<Integer>();

		int chiffre = -1;
		chiffre = afficheDonnee(xTab + 1, yTab);
		if (chiffre != -1) {
			chiffres.add(chiffre);
		}
		chiffre = afficheDonnee(xTab - 1, yTab);
		if (chiffre != -1) {
			chiffres.add(chiffre);
		}
		chiffre = afficheDonnee(xTab, yTab + 1);
		if (chiffre != -1) {
			chiffres.add(chiffre);
		}
		chiffre = afficheDonnee(xTab, yTab - 1);
		if (chiffre != -1) {
			chiffres.add(chiffre);
		}
		return chiffres;
	}

	private static int afficheDonnee(int xTab, int yTab) {
		if (valideDonnee(xTab, yTab)) {
			System.out.println(datas[xTab][yTab]);
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
