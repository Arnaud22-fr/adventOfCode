package advent2021.day5;

import java.util.List;

public class Main1 {

	public static void main(String[] args) {

		List<String> datas = Datas.getDatastest();
//		List<String> datas = Datas.getDatas();

		Integer result = 0;

		int dimension = 0;

		for (String ventHydrothermal : datas) {

			String entree = ventHydrothermal.split(";")[0];
			String sortie = ventHydrothermal.split(";")[1];
			int xa = Integer.parseInt(entree.split(",")[0]);
			int ya = Integer.parseInt(entree.split(",")[1]);
			int xb = Integer.parseInt(sortie.split(",")[0]);
			int yb = Integer.parseInt(sortie.split(",")[0]);

			dimension = Math.max(dimension, xa);
			dimension = Math.max(dimension, xb);
			dimension = Math.max(dimension, ya);
			dimension = Math.max(dimension, yb);

		}
		int[][] carte = new int[dimension + 1][dimension + 1];

		for (String ventHydrothermal : datas) {

			String entree = ventHydrothermal.split(";")[0];
			String sortie = ventHydrothermal.split(";")[1];
			int xa = Integer.parseInt(entree.split(",")[0]);
			int ya = Integer.parseInt(entree.split(",")[1]);
			int xb = Integer.parseInt(sortie.split(",")[0]);
			int yb = Integer.parseInt(sortie.split(",")[1]);

			if (xa == xb) {
				for (int y = Math.min(ya, yb); y < Math.max(ya, yb) + 1; y++) {
					carte[y][xa] += 1;
				}
			} else if (ya == yb) {
				for (int x = Math.min(xa, xb); x < Math.max(xa, xb) + 1; x++) {
					carte[ya][x] += 1;
				}
			}

		}

		afficherCarte(carte);

		for (int i = 0; i < carte.length; i++) {
			for (int j = 0; j < carte.length; j++) {
				if (carte[i][j] > 1)
					result++;
			}
		}

		System.out.println(result);
	}

	private static void afficherCarte(int[][] carte) {

		String debug = "";

		for (int i = 0; i < carte.length; i++) {
			for (int j = 0; j < carte.length; j++) {
				debug += carte[i][j];
			}
			System.out.println(debug + "\n");
			debug = "";
		}

	}

}
