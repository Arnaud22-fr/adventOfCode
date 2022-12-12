package advent2022.day12;

import java.util.ArrayList;

// Algorithme de Bellman-Ford
public class BellmanFord extends Algorithme {
	public BellmanFord(Graphe _graphe, IHM _ihm) {
		super(_graphe, _ihm);
	}

	@Override
	protected void run() {
		// Initialisation
		boolean distanceChangee = true;
		int i = 0;
		ArrayList<Arc> listeArcs = graphe.listeArcs();

		// Boucle principale
		int nbBoucleMax = graphe.nombreNoeuds() - 1;
		while (i < nbBoucleMax && distanceChangee) {
			distanceChangee = false;
			for (Arc arc : listeArcs) {
				if (arc.source.distanceDuDepart + arc.cout < arc.cible.distanceDuDepart) {
					// On a trouv� un chemin plus court
					arc.cible.distanceDuDepart = arc.source.distanceDuDepart + arc.cout;
					arc.cible.precurseur = arc.source;
					distanceChangee = true;
				}
			}
			i++;
		}

		// Test si boucle négative
		for (Arc arc : listeArcs) {
			if (arc.source.distanceDuDepart + arc.cout < arc.cible.distanceDuDepart) {
				System.err.println("Boucle négative - pas de chemin le plus court");
			}
		}
	}
}
