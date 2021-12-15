package advent2021.day15;

public abstract class Algorithme {
	protected Graphe graphe;
	protected IHM ihm;

	public Algorithme(Graphe _graphe, IHM _ihm) {
		graphe = _graphe;
		ihm = _ihm;
	}

	public final void resoudre() {
		graphe.effacer();
		run();
		ihm.AfficherResultat(graphe.reconstruireChemin(), graphe.noeudSortie().distanceDuDepart);
	}

	protected abstract void run();
}
