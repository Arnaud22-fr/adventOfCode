package advent2022.day12;

import java.util.ArrayList;

// Interface d�finissant les graphes
public interface Graphe {
	// Informations sur le graphe
	Noeud noeudDepart();

	Noeud noeudSortie();

	// R�cup�ration des noeuds et des arcs
	ArrayList<Noeud> listeNoeuds();

	ArrayList<Noeud> listeNoeudsAdjacents(Noeud source);

	ArrayList<Arc> listeArcs();

	ArrayList<Arc> listeArcsSortants(Noeud source);

	// M�thodes utilitaires
	int nombreNoeuds();

	double cout(Noeud depart, Noeud arrivee);

	String reconstruireChemin();

	void calculerDistancesEstimees();

	void effacer();
}
