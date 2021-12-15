package advent2021.day15;

import java.util.ArrayList;

// Interface définissant les graphes
public interface Graphe {
	// Informations sur le graphe
	Noeud noeudDepart();

	Noeud noeudSortie();

	// Récupération des noeuds et des arcs
	ArrayList<Noeud> listeNoeuds();

	ArrayList<Noeud> listeNoeudsAdjacents(Noeud source);

	ArrayList<Arc> listeArcs();

	ArrayList<Arc> listeArcsSortants(Noeud source);

	// Méthodes utilitaires
	int nombreNoeuds();

	double cout(Noeud depart, Noeud arrivee);

	String reconstruireChemin();

	void calculerDistancesEstimees();

	void effacer();
}
