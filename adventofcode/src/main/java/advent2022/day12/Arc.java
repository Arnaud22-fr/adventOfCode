package advent2022.day12;

// Arc dans le graphe
public class Arc {
	protected Noeud source;
	protected Noeud cible;
	protected double cout;

	public Arc(Noeud _source, Noeud _cible, double _cout) {
		source = _source;
		cible = _cible;
		cout = _cout;
	}
}
