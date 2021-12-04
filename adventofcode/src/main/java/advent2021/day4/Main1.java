package advent2021.day4;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

//	public static List<Integer> datasNumeros = Datas.getNumerosTest();
//	public static List<int[][]> datasGrilles = Datas.getGrillesTest();
	public static List<Integer> datasNumeros = Datas.getNumeros();
	public static List<int[][]> datasGrilles = Datas.getGrilles();

	public static void main(String[] args) {
		int result = 0;
		boolean faireGagnerCalamar = true;
		int nbGrilleGagnanteSortie = 0;

		List<Grille> grilles = new ArrayList<Grille>();
		for (int[][] grille : datasGrilles) {
			grilles.add(new Grille(grille));
		}

		List<Integer> numerosSortis = new ArrayList<Integer>();
		for (Integer numero : datasNumeros) {

			numerosSortis.add(numero);
			if (numerosSortis.size() > 4) {

				for (Grille grille : grilles) {

					if (!grille.isGagnate()) {
						result = grille.isBingo(numerosSortis);
						if (result != 0) {
							if (!faireGagnerCalamar) {
								break;
							} else {
								nbGrilleGagnanteSortie++;
								if (nbGrilleGagnanteSortie == datasGrilles.size()) {
									break;
								}
							}
						}
					}
				}
				if (faireGagnerCalamar) {
					if (nbGrilleGagnanteSortie == datasGrilles.size()) {
						break;
					}
				} else {
					if (result != 0) {
						break;
					}
				}
			}
		}

		System.out.println(result);

	}

}
