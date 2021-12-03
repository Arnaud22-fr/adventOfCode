package advent.day11;

public class Coordonnee {

	public static int colonne;
	public static int ligne;

	public static String getValue() {
		if (colonne < 0 || ligne < 0 || colonne > Day112.dataSet.length - 1
				|| ligne > Day112.ligneCourante.length - 1) {
			return Day112.OUT;
		} else {
			if (Day112.NAN.equalsIgnoreCase(Day112.dataSet[ligne][colonne])) {
				return "";
			} else {
				return Day112.dataSet[ligne][colonne];
			}
		}

	}

}
