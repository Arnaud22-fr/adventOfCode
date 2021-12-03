package advent.day11;

public class Day11 {

	static String[][] dataSet = DatasDay11.getEntrees();
	static String[][] oldDataSet = new String[DatasDay11.getEntrees().length][dataSet[0].length];
	static String[][] newDataSet = new String[DatasDay11.getEntrees().length][dataSet[0].length];
	static String[] ligne = {};
	static String[][] matrice = {};
	final static String LIBRE = "L";
	final static String OCCUPE = "#";
	final static String NAN = ".";

	public static void main(String[] args) {

		oldDataSet = copie(dataSet);
		boolean stop = false;

		while (!stop) {

			for (int i = 0; i < dataSet.length; i++) {

				ligne = dataSet[i];

				for (int j = 0; j < ligne.length; j++) {
//					if (j == 16) {
//						System.out.println(dataSet[i][j]);
//					}
					newDataSet[i][j] = transormation(i, j);
				}
			}
			for (int i = 0; i < newDataSet.length; i++) {
				String ligneAff = "";
				for (int j = 0; j < ligne.length; j++) {
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

	private static void buildMatrice(int i, int j) {

		reinitMatrice();
//		if (j == 97) {
//
//			System.out.println(i + ";" + j);
//		}

		if (i > 0 && j > 0) {
			matrice[0][0] = dataSet[i - 1][j - 1];
		}
		if (i > 0) {
			matrice[0][1] = dataSet[i - 1][j];
		}
		if (i > 0 && j < ligne.length - 1) {
			matrice[0][2] = dataSet[i - 1][j + 1];
		}
		if (j > 0) {
			matrice[1][0] = dataSet[i][j - 1];
		}
		matrice[1][1] = dataSet[i][j];
		if (j < ligne.length - 1) {
			matrice[1][2] = dataSet[i][j + 1];
		}
		if (i < dataSet.length - 1 && j > 0) {
			matrice[2][0] = dataSet[i + 1][j - 1];
		}
		if (i < dataSet.length - 1) {
			matrice[2][1] = dataSet[i + 1][j];
		}
		if (i < dataSet.length - 1 && j < ligne.length - 1) {
			matrice[2][2] = dataSet[i + 1][j + 1];
		}

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
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
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
			if (nbOccupe >= 4)
				return LIBRE;
		}

		return dataSet[i][j];

	}

}
