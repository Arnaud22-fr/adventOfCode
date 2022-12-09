package advent2022.day08;

public class Main1 {

	public static void main(String[] args) {

		int result = 0;
		int nbArbreParcourru = 0;

		int[][] trees = Datas.getTrees();

		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees[0].length; j++) {
				System.out.println("i>" + i + ", j>" + j + " => " + trees[i][j]);

				nbArbreParcourru++;
				if (i == 0 || i == trees.length - 1 || j == 0 || j == trees[0].length - 1) {
					System.out.println("OK");
					result++;
				} else {

					if (verifierVisibilite(i, j, trees) > 0) {
						result++;
						System.out.println("OK");
					} else {
						System.out.println("NON");

					}
				}

			}
		}
		System.out.println("nb arbre parcouru > " + nbArbreParcourru);

		System.out.println("nb arbre visible > " + result);
	}

	private static int verifierVisibilite(int i, int j, int[][] trees) {
		boolean estSuperieur = true;
		// A gauche
		for (int g = j - 1; g > -1; g--) {
			if (trees[i][g] >= trees[i][j]) {
				estSuperieur = false;
				break;
			}
		}
		if (estSuperieur)
			return 1;
		estSuperieur = true;
		// A droite
		for (int d = j + 1; d < trees[0].length; d++) {
			if (trees[i][d] >= trees[i][j]) {
				estSuperieur = false;
				break;
			}
		}
		if (estSuperieur)
			return 1;
		estSuperieur = true;
		// En haut
		for (int h = i - 1; h > -1; h--) {
			if (trees[h][j] >= trees[i][j]) {
				estSuperieur = false;
				break;
			}
		}
		if (estSuperieur)
			return 1;
		estSuperieur = true;
		// En bas
		if (i == 97 && j == 96) {
			System.out.println("Doit etre ok en bas");
		}
		for (int b = i + 1; b < trees.length; b++) {
			if (trees[b][j] >= trees[i][j]) {
				estSuperieur = false;
				break;
			}
		}
		return estSuperieur ? 1 : 0;

	}

}
