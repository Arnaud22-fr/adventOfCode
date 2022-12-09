package advent2022.day08;

public class Main2 {

	public static void main(String[] args) {

		int result = 0;

		int[][] trees = Datas.getTrees();

		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j < trees[0].length; j++) {
				System.out.println("i>" + i + ", j>" + j + " => " + trees[i][j]);

				int currentScenicScore = verifierVisibilite(i, j, trees);
				if (currentScenicScore > result) {
					result = currentScenicScore;
				}

			}
		}

		System.out.println("Meilleur score scenic > " + result);
	}

	private static int verifierVisibilite(int i, int j, int[][] trees) {
		int scenicScore = 1;
		int scoreHaut = 0;
		int scoreBas = 0;
		int scoreGauche = 0;
		int scoreDroite = 0;

		// A gauche
		for (int g = j - 1; g > -1; g--) {
			scoreGauche++;
			if (trees[i][g] >= trees[i][j]) {
				break;
			}
		}
		System.out.println("Score Gauche > " + scoreGauche);
		// A droite
		for (int d = j + 1; d < trees[0].length; d++) {
			scoreDroite++;
			if (trees[i][d] >= trees[i][j]) {
				break;
			}
		}
		System.out.println("Score Droite > " + scoreDroite);
		// En haut
		for (int h = i - 1; h > -1; h--) {
			scoreHaut++;
			if (trees[h][j] >= trees[i][j]) {
				break;
			}
		}
		System.out.println("Score Haut > " + scoreHaut);
		// En bas
//		if (i == 97 && j == 96) {
//			System.out.println("Doit etre ok en bas");
//		}
		for (int b = i + 1; b < trees.length; b++) {
			scoreBas++;
			if (trees[b][j] >= trees[i][j]) {
				break;
			}
		}
		System.out.println("Score Bas > " + scoreBas);
		scenicScore = scoreGauche * scoreDroite * scoreHaut * scoreBas;
		System.out.println(scenicScore);
		return scenicScore;

	}

}
