package advent2021.day13;

import java.util.List;

public class Main1 {

//	static List<Coordonnees> datas = Datas.getDataTest();
//	static List<String> instructions = Datas.getInstructionstest();

	static List<Coordonnees> datas = Datas.getData();
	static List<String> instructions = Datas.getInstructions();

	public static void main(String[] args) throws Exception {

		int tailleColonne = 0;
		int tailleLigne = 0;

		for (Coordonnees coordonnee : datas) {
			if (coordonnee.getX() > tailleColonne) {
				tailleColonne = coordonnee.getX();
			}
			if (coordonnee.getY() > tailleLigne) {
				tailleLigne = coordonnee.getY();
			}

		}

		String[][] carte = new String[tailleLigne + 1][tailleColonne + 1];
		initCarte(carte);
		afficherCarte(carte);

		for (String instruction : instructions) {
			System.out.println(instruction);
			String[][] nouvelleCarte = plier(carte, instruction);
			System.out.println("");
			afficherCarte(nouvelleCarte);
			carte = new String[nouvelleCarte.length][nouvelleCarte[0].length];
			carte = nouvelleCarte;
			System.out.println("stop");
		}

//		String[][] nouvelleCarte2 = plier(nouvelleCarte, instructions.get(1));
//		System.out.println("");
//		afficherCarte(nouvelleCarte2);

//		int result = 0;
//		for (int x = 0; x < nouvelleCarte.length; x++) {
//			for (int y = 0; y < nouvelleCarte[0].length; y++) {
//				if (nouvelleCarte[x][y].equalsIgnoreCase("#")) {
//					result++;
//				}
//			}
//		}
//		System.out.println(result);

	}

	private static String[][] plier(String[][] carte, String instruction) {

		if (instruction.contains("x")) {
			return plierVerticalement(carte, Integer.valueOf(instruction.substring(instruction.lastIndexOf("=") + 1)));
		} else {
			return plierHorizontalement(carte,
					Integer.valueOf(instruction.substring(instruction.lastIndexOf("=") + 1)));
		}

	}

	private static String[][] plierHorizontalement(String[][] carte, int ligneDePli) {
		String[][] nouvelleCarte = new String[(int) carte.length / 2][carte[0].length];

		for (int x = 0; x < nouvelleCarte.length; x++) {
			for (int y = 0; y < nouvelleCarte[0].length; y++) {
				nouvelleCarte[x][y] = carte[x][y];
			}
		}
		int incr = 1;
		for (int x = carte.length - ligneDePli + 1; x < carte.length; x++) {
			incr++;
			for (int y = 0; y < carte[0].length; y++) {
				int xNouvelleCarte = ligneDePli - incr;
				fusionHorizontale(nouvelleCarte, carte, xNouvelleCarte, x, y);
			}
		}

		return nouvelleCarte;
	}

	private static String[][] plierVerticalement(String[][] carte, int colonneDePli) {
		String[][] nouvelleCarte = new String[carte.length][(int) carte[0].length / 2];

		for (int x = 0; x < nouvelleCarte.length; x++) {
			for (int y = 0; y < nouvelleCarte[0].length; y++) {
				nouvelleCarte[x][y] = carte[x][y];
			}
		}

		for (int x = 0; x < carte.length; x++) {

			int incr = 0;
			for (int y = carte[0].length - colonneDePli; y < carte[0].length; y++) {
				incr++;
				int yNouvelleCarte = colonneDePli - incr;
				fusionVerticale(nouvelleCarte, carte, yNouvelleCarte, x, y);
			}
		}

		return nouvelleCarte;

	}

	private static void fusionHorizontale(String[][] nouvelleCarte, String[][] carte, int xNouvelleCarte, int x,
			int y) {
		if (carte[x][y].equalsIgnoreCase("#")) {
			nouvelleCarte[xNouvelleCarte][y] = "#";
		}

	}

	private static void fusionVerticale(String[][] nouvelleCarte, String[][] carte, int yNouvelleCarte, int x, int y) {
		if (carte[x][y].equalsIgnoreCase("#")) {
			nouvelleCarte[x][yNouvelleCarte] = "#";
		}

	}

	private static void afficherCarte(String[][] carte) {

		for (int x = 0; x < carte.length; x++) {
			String ligne = "";
			for (int y = 0; y < carte[0].length; y++) {
				ligne += carte[x][y];
			}
			System.out.println(ligne);
		}

	}

	private static void initCarte(String[][] carte) {
		for (int x = 0; x < carte.length; x++) {
			for (int y = 0; y < carte[0].length; y++) {
				carte[x][y] = ".";
			}
		}
		for (Coordonnees coordonnee : datas) {
			carte[coordonnee.getY()][coordonnee.getX()] = "#";

		}

	}

}
