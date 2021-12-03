package advent.day11;

public class Day112 {

//	static String[][] dataSet = DatasDay11.getExemple();
	static String[][] dataSet = DatasDay11.getEntrees();
	static String[][] oldDataSet = new String[dataSet.length][dataSet[0].length];
	static String[][] newDataSet = new String[dataSet.length][dataSet[0].length];
	static String[] ligneCourante = {};
	static String[][] matrice = {};
	final static String LIBRE = "L";
	final static String OCCUPE = "#";
	final static String NAN = ".";
	final static String OUT = "X";

	public static void main(String[] args) {

		oldDataSet = copie(dataSet);
		boolean stop = false;

		while (!stop) {

			for (int ligne = 0; ligne < dataSet.length; ligne++) {

				ligneCourante = dataSet[ligne];

				for (int colonne = 0; colonne < ligneCourante.length; colonne++) {
					if (ligne == 0 && colonne == 96) {
						System.out.println(dataSet[ligne][colonne]);
					}
					newDataSet[ligne][colonne] = transormation(ligne, colonne);
				}
			}
			for (int i = 0; i < newDataSet.length; i++) {
				String ligneAff = "";
				for (int j = 0; j < ligneCourante.length; j++) {
					ligneAff += newDataSet[i][j];
				}
				System.out.println(ligneAff);
			}

			System.out.println("================================");

			if (verifierEgalite(oldDataSet, newDataSet)) {
				stop = true;
			} else {
				dataSet = copie(newDataSet);
//				if (dataSet.equals(newDataSet)) {
//					System.out.println("c'est égale");
//				}
				oldDataSet = copie(newDataSet);
			}

		}

		System.out.println(countSeat(oldDataSet));
	}

	private static boolean verifierEgalite(String[][] oldDataSet2, String[][] newDataSet2) {

		for (int i = 0; i < oldDataSet2.length; i++) {
			for (int j = 0; j < oldDataSet2[i].length; j++) {
				if (oldDataSet2[i][j] != newDataSet2[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	private static String[][] copie(String[][] datas) {

		String[][] copie = new String[dataSet.length][dataSet[0].length];

		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				copie[i][j] = datas[i][j];
			}
		}

		return copie;
	}

	private static int countSeat(String[][] datas) {
		int resultat = 0;
		for (String[] ligne : datas) {
			for (String siege : ligne) {
				if (siege.equalsIgnoreCase(OCCUPE)) {
					resultat += 1;
				}
			}
		}
		return resultat;
	}

	private static void buildMatrice(int ligne, int colonne) {

		reinitMatrice();

		String resultTmp = "";
		Coordonnee.colonne = 0;
		Coordonnee.ligne = 0;

		// Recherche du point haut gauche
		Coordonnee.colonne = colonne - 1;
		Coordonnee.ligne = ligne - 1;
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne--;
			Coordonnee.ligne--;
		}
		matrice[0][0] = resultTmp;

		// Recherche du point haut
		Coordonnee.colonne = colonne;
		Coordonnee.ligne = ligne - 1;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.ligne--;
		}
		matrice[0][1] = resultTmp;

		// Recherche du point haut droite
		Coordonnee.colonne = colonne + 1;
		Coordonnee.ligne = ligne - 1;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne++;
			Coordonnee.ligne--;
		}
		matrice[0][2] = resultTmp;

		// Recherche du point gauche
		Coordonnee.colonne = colonne - 1;
		Coordonnee.ligne = ligne;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne--;
		}
		matrice[1][0] = resultTmp;

		// Recherche du point droite
		Coordonnee.colonne = colonne + 1;
		Coordonnee.ligne = ligne;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne++;
		}
		matrice[1][2] = resultTmp;

		// Recherche du point bas gauche
		Coordonnee.colonne = colonne - 1;
		Coordonnee.ligne = ligne + 1;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne--;
			Coordonnee.ligne++;
		}
		matrice[2][0] = resultTmp;

		// Recherche du point bas
		Coordonnee.colonne = colonne;
		Coordonnee.ligne = ligne + 1;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.ligne++;
		}
		matrice[2][1] = resultTmp;

		// Recherche du point bas droite
		Coordonnee.colonne = colonne + 1;
		Coordonnee.ligne = ligne + 1;
		resultTmp = "";
		while ("".equalsIgnoreCase(resultTmp)) {
			resultTmp = Coordonnee.getValue();
			Coordonnee.colonne++;
			Coordonnee.ligne++;
		}
		matrice[2][2] = resultTmp;

		matrice[1][1] = oldDataSet[ligne][colonne];

//		System.out.println(matrice[0][0] + matrice[0][1] + matrice[0][2]);
//		System.out.println(matrice[1][0] + matrice[1][1] + matrice[1][2]);
//		System.out.println(matrice[2][0] + matrice[2][1] + matrice[2][2]);
//		System.out.println("=======");

	}

	private static void reinitMatrice() {
		matrice = new String[3][3];
		matrice[0][0] = ".";
		matrice[0][1] = ".";
		matrice[0][2] = ".";
		matrice[1][0] = ".";
		matrice[1][1] = ".";
		matrice[1][2] = ".";
		matrice[2][0] = ".";
		matrice[2][1] = ".";
		matrice[2][2] = ".";

	}

	private static String transormation(int i, int j) {
		buildMatrice(i, j);
		int nbLibre = 0;
		int nbOccupe = 0;
		for (int k = 0; k < matrice.length; k++) {
			for (int l = 0; l < matrice.length; l++) {
				if (!(k == 1 && l == 1)) {

					switch (matrice[k][l]) {
					case LIBRE:
						nbLibre++;
						break;
					case OCCUPE:
						nbOccupe++;
						break;

					default:
						break;
					}
				}
			}
		}

		if (dataSet[i][j].equalsIgnoreCase(LIBRE)) {
			if (nbOccupe == 0)
				return OCCUPE;
		}

		if (dataSet[i][j].equalsIgnoreCase(OCCUPE)) {
			if (nbOccupe >= 5)
				return LIBRE;
		}

		return dataSet[i][j];

	}

}
