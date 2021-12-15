package advent2021.day15;

public class Tuile extends Noeud {
	protected TypeTuile type;
	protected int ligne;
	protected int colonne;

	public Tuile(TypeTuile _type, int _ligne, int _colonne) {
		type = _type;
		ligne = _ligne;
		colonne = _colonne;
	}

	// Indique si la case est accessible ou non
	boolean Accessible() {
		return (type.equals(TypeTuile.un) || type.equals(TypeTuile.deux) || type.equals(TypeTuile.trois)
				|| type.equals(TypeTuile.quatre) || type.equals(TypeTuile.cinq) || type.equals(TypeTuile.six)
				|| type.equals(TypeTuile.sept) || type.equals(TypeTuile.huit) || type.equals(TypeTuile.neuf));
	}

	// Renvoie le cout de la case
	double Cout() {
		switch (type) {
		case un:
			return 1;
		case deux:
			return 2;
		case trois:
			return 3;
		case quatre:
			return 4;
		case cinq:
			return 5;
		case six:
			return 6;
		case sept:
			return 7;
		case huit:
			return 8;
		case neuf:
			return 9;
		default:
			return Double.POSITIVE_INFINITY;
		}
	}

	@Override
	public String toString() {
		return "[" + ligne + ";" + colonne + ";" + type.toString() + "]";
	}
}
