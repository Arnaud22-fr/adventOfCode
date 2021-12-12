package advent2021.day11;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

//	static int[][] datas = Datas.getDataTest();
	static int[][] datas = Datas.getData();
	static boolean allInligth = true;

	public static void main(String[] args) {
		int result = 0;

		if (allInligth) {
			int i = 0;
			while (!allInligth()) {

				System.out.println("Step " + i);
				afficherDatas(datas);
				result += doStep(0);
				System.out.println(++i);
			}
		} else {

			for (int i = 0; i < 100; i++) {

				System.out.println("Step " + i);
				afficherDatas(datas);
				result += doStep(0);
				System.out.println(result);
			}
		}
		System.out.println(result);
	}

	private static boolean allInligth() {

		for (int x = 0; x < datas.length; x++) {
			for (int y = 0; y < datas[0].length; y++) {
				if (datas[x][y] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int doStep(int result) {

		for (int x = 0; x < datas.length; x++) {
			for (int y = 0; y < datas[0].length; y++) {
				if (datas[x][y] < 9) {
					datas[x][y] += 1;
				} else {
					datas[x][y] = 0;
				}
			}
		}

		System.out.println("");
		afficherDatas(datas);

		List<Coordonnee> dejaProc = new ArrayList<Coordonnee>();
		for (int x = 0; x < datas.length; x++) {
			for (int y = 0; y < datas[0].length; y++) {
				if (datas[x][y] == 0 && !isPresent(dejaProc, x, y)) {
					result = highlighted(x, y, result, dejaProc);
				}
			}
		}

		System.out.println("");
		afficherDatas(datas);

		return result;
	}

	private static void afficherDatas(int[][] datas) {
		for (int x = 0; x < datas.length; x++) {
			String ligne = "";
			for (int y = 0; y < datas[0].length; y++) {
				ligne += datas[x][y];
			}
			System.out.println(ligne);
		}

	}

	private static int highlighted(int x, int y, int result, List<Coordonnee> dejaProc) {

		if (datas[x][y] == 0 && !isPresent(dejaProc, x, y)) {
			dejaProc.add(new Coordonnee(x, y));
			result++;
		}

		List<Coordonnee> entourrage = getEntourrage(x, y);
		for (Coordonnee coordonnee : entourrage) {
			if (datas[coordonnee.getX()][coordonnee.getY()] != 0) {

				if (datas[coordonnee.getX()][coordonnee.getY()] < 9) {
					datas[coordonnee.getX()][coordonnee.getY()] += 1;
				} else {
					if (!isPresent(dejaProc, coordonnee.getX(), coordonnee.getY())) {
						datas[coordonnee.getX()][coordonnee.getY()] = 0;
						result = highlighted(coordonnee.getX(), coordonnee.getY(), result, dejaProc);
					}
				}
			} else {
				if (!isPresent(dejaProc, coordonnee.getX(), coordonnee.getY())) {
					result = highlighted(coordonnee.getX(), coordonnee.getY(), result, dejaProc);
				}
			}
		}
		return result;

	}

	private static boolean isPresent(List<Coordonnee> dejaProc, int x, int y) {
		boolean isPresent = false;
		for (Coordonnee coordonne : dejaProc) {
			if (coordonne.getX() == x && coordonne.getY() == y) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}

	public static List<Coordonnee> getEntourrage(int xTab, int yTab) {
		List<Coordonnee> coordonnees = new ArrayList<Coordonnee>();
		for (int y = yTab - 1; y <= yTab + 1; y++) {
			for (int x = xTab - 1; x <= xTab + 1; x++) {
				if (x != xTab || y != yTab) {
					Coordonnee coordonne = afficheDonnee(x, y);
					if (coordonne != null) {
						coordonnees.add(coordonne);
					}
				}
			}
		}
		return coordonnees;
	}

	private static Coordonnee afficheDonnee(int xTab, int yTab) {
		if (valideDonnee(xTab, yTab)) {
			return new Coordonnee(xTab, yTab);
		} else {
			return null;
		}

	}

	// Verifier qu'on ne depasse pas le tableau (a ne pas oublier).
	private static boolean valideDonnee(int xTab, int yTab) {
		if (xTab < 0 || xTab >= datas.length)
			return false;
		return !(yTab < 0 || yTab >= datas[0].length);
	}

}
