package advent2022.day12;

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
	boolean Accessible(Tuile source) {
		if (
//				(int) type.toString().charAt(0) == (int) source.type.toString().charAt(0)|| 
		(int) type.toString().charAt(0) == (int) source.type.toString().charAt(0) + 1
				|| (int) type.toString().charAt(0) <= (int) source.type.toString().charAt(0)) {
			return true;
		}
		return false;
//		return (type.equals(TypeTuile.un) || type.equals(TypeTuile.deux) || type.equals(TypeTuile.trois)
//				|| type.equals(TypeTuile.quatre) || type.equals(TypeTuile.cinq) || type.equals(TypeTuile.six)
//				|| type.equals(TypeTuile.sept) || type.equals(TypeTuile.huit) || type.equals(TypeTuile.neuf));
//		return true;
	}

	// Renvoie le cout de la case
	double Cout() {
		switch (type) {
		case a:
			return 26;
		case b:
			return 25;
		case c:
			return 24;
		case d:
			return 23;
		case e:
			return 22;
		case f:
			return 21;
		case g:
			return 20;
		case h:
			return 19;
		case i:
			return 18;
		case j:
			return 17;
		case k:
			return 16;
		case l:
			return 15;
		case m:
			return 14;
		case n:
			return 13;
		case o:
			return 12;
		case p:
			return 11;
		case q:
			return 10;
		case r:
			return 9;
		case s:
			return 8;
		case t:
			return 7;
		case u:
			return 6;
		case v:
			return 5;
		case w:
			return 4;
		case x:
			return 3;
		case y:
			return 2;
		case z:
			return 1;
		default:
			return Double.POSITIVE_INFINITY;
		}
	}

	@Override
	public String toString() {
		return "[" + ligne + ";" + colonne + ";" + type.toString() + "]";
	}
}
