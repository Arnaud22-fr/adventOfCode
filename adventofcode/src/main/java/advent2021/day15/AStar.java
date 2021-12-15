package advent2021.day15;

import java.util.ArrayList;

// Algorithme A*
public class AStar extends Algorithme {

	// Constructeur
	public AStar(Graphe _graphe, IHM _ihm) {
		super(_graphe, _ihm);
	}

	@Override
	protected void run() {
		// Initialisation
		graphe.calculerDistancesEstimees();
		ArrayList<Noeud> listeNoeuds = graphe.listeNoeuds();
		boolean sortieTrouvee = false;

		while (listeNoeuds.size() != 0 && !sortieTrouvee) {
			// Recherche du noeud avec la distance la plus faible
			Noeud noeudCourant = listeNoeuds.get(0);
			for (Noeud noeud : listeNoeuds) {
				if (noeud.distanceDuDepart + noeud.distanceEstimee < noeudCourant.distanceDuDepart
						+ noeudCourant.distanceEstimee) {
					noeudCourant = noeud;
				}
			}

			if (noeudCourant.equals(graphe.noeudSortie())) {
				// On a trouvé la sortie
				sortieTrouvee = true;
			} else {
				// On applique les arcs sortants de ce noeud
				ArrayList<Arc> arcsSortants = graphe.listeArcsSortants(noeudCourant);

				for (Arc arc : arcsSortants) {
					if (arc.source.distanceDuDepart + arc.cout < arc.cible.distanceDuDepart) {
						arc.cible.distanceDuDepart = arc.source.distanceDuDepart + arc.cout;
						arc.cible.precurseur = arc.source;
					}
				}

				listeNoeuds.remove(noeudCourant);
			}
		}
	}
}
