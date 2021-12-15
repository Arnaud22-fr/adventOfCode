package advent2021.day15;

import java.util.ArrayList;
import java.util.Arrays;

public class Carte implements Graphe {

	// Attributs
	Tuile[][] tuiles;
	int nbLignes;
	int nbColonnes;
	Tuile noeudDepart;
	Tuile noeudArrivee;
	ArrayList<Noeud> listeNoeuds = null;
	ArrayList<Arc> listeArcs = null;

	public Carte(String[] lignes, int _ligneDepart, int _colonneDepart, int _ligneArrivee, int _colonneArrivee) {
		// Création du tableau de tuiles
		nbLignes = lignes.length;
		nbColonnes = lignes[0].length();
		tuiles = new Tuile[nbLignes][];

		// Remplissage
		for (int i = 0; i < nbLignes; i++) {
			tuiles[i] = new Tuile[nbColonnes];
			for (int j = 0; j < nbColonnes; j++) {
				TypeTuile type = ConvertisseurTypeTuile.charToType(lignes[i].charAt(j));
				tuiles[i][j] = new Tuile(type, i, j);
			}
		}

		// Départ et arrivée
		noeudDepart = tuiles[_ligneDepart][_colonneDepart];
		noeudDepart.distanceDuDepart = noeudDepart.Cout();
		noeudArrivee = tuiles[_ligneArrivee][_colonneArrivee];

		listeNoeuds();
		listeArcs();
	}

	@Override
	public Noeud noeudDepart() {
		return noeudDepart;
	}

	@Override
	public Noeud noeudSortie() {
		return noeudArrivee;
	}

	@Override
	public ArrayList<Noeud> listeNoeuds() {
		if (listeNoeuds == null) {
			listeNoeuds = new ArrayList();
			for (int i = 0; i < nbLignes; i++) {
				listeNoeuds.addAll(Arrays.asList(tuiles[i]));
			}
		}
		return listeNoeuds;
	}

	@Override
	public ArrayList<Noeud> listeNoeudsAdjacents(Noeud source) {
		// Initialisation
		ArrayList<Noeud> listeNoeudsSortants = new ArrayList();
		int ligne = ((Tuile) source).ligne;
		int colonne = ((Tuile) source).colonne;

		// Voisin de droite
		if (colonne - 1 >= 0 && tuiles[ligne][colonne - 1].Accessible()) {
			listeNoeudsSortants.add(tuiles[ligne][colonne - 1]);
		}

		// Voisin de gauche
		if (colonne + 1 < nbColonnes && tuiles[ligne][colonne + 1].Accessible()) {
			listeNoeudsSortants.add(tuiles[ligne][colonne + 1]);
		}

		// Voisin du haut
		if (ligne - 1 >= 0 && tuiles[ligne - 1][colonne].Accessible()) {
			listeNoeudsSortants.add(tuiles[ligne - 1][colonne]);
		}

		// Voisin du bas
		if (ligne + 1 < nbLignes && tuiles[ligne + 1][colonne].Accessible()) {
			listeNoeudsSortants.add(tuiles[ligne + 1][colonne]);
		}
		return listeNoeudsSortants;
	}

	@Override
	public int nombreNoeuds() {
		return nbLignes * nbColonnes;
	}

	@Override
	public ArrayList<Arc> listeArcsSortants(Noeud source) {
		ArrayList<Arc> listeArcsSortants = new ArrayList();
		int ligne = ((Tuile) source).ligne;
		int colonne = ((Tuile) source).colonne;

		if (tuiles[ligne][colonne].Accessible()) {
			// Droite
			if (colonne - 1 >= 0 && tuiles[ligne][colonne - 1].Accessible()) {
				listeArcsSortants.add(
						new Arc(tuiles[ligne][colonne], tuiles[ligne][colonne - 1], tuiles[ligne][colonne - 1].Cout()));
			}

			// Gauche
			if (colonne + 1 < nbColonnes && tuiles[ligne][colonne + 1].Accessible()) {
				listeArcsSortants.add(
						new Arc(tuiles[ligne][colonne], tuiles[ligne][colonne + 1], tuiles[ligne][colonne + 1].Cout()));
			}

			// Haut
			if (ligne - 1 >= 0 && tuiles[ligne - 1][colonne].Accessible()) {
				listeArcsSortants.add(
						new Arc(tuiles[ligne][colonne], tuiles[ligne - 1][colonne], tuiles[ligne - 1][colonne].Cout()));
			}

			// Bas
			if (ligne + 1 < nbLignes && tuiles[ligne + 1][colonne].Accessible()) {
				listeArcsSortants.add(
						new Arc(tuiles[ligne][colonne], tuiles[ligne + 1][colonne], tuiles[ligne + 1][colonne].Cout()));
			}
		}
		return listeArcsSortants;
	}

	@Override
	public ArrayList<Arc> listeArcs() {
		if (listeArcs == null) {
			listeArcs = new ArrayList();

			// Parcours des noeuds
			for (int ligne = 0; ligne < nbLignes; ligne++) {
				for (int colonne = 0; colonne < nbColonnes; colonne++) {
					ArrayList<Arc> arcs = listeArcsSortants(tuiles[ligne][colonne]);
					listeArcs.addAll(arcs);
				}
			}
		}
		return listeArcs;
	}

	@Override
	public double cout(Noeud depart, Noeud arrivee) {
		return ((Tuile) arrivee).Cout();
	}

	@Override
	public String reconstruireChemin() {
		// Initialisation
		String chemin = "";
		Tuile noeudCourant = noeudArrivee;
		Tuile noeudPrecedent = (Tuile) noeudArrivee.precurseur;

		// Boucle sur les noeuds du chemin
		while (noeudPrecedent != null) {
			chemin = "-" + noeudCourant.toString() + chemin;
			noeudCourant = noeudPrecedent;
			noeudPrecedent = (Tuile) noeudCourant.precurseur;
		}
		chemin = noeudCourant.toString() + chemin;
		return chemin;
	}

	@Override
	public void calculerDistancesEstimees() {
		for (int ligne = 0; ligne < nbLignes; ligne++) {
			for (int colonne = 0; colonne < nbColonnes; colonne++) {
				tuiles[ligne][colonne].distanceEstimee = Math.abs(noeudArrivee.ligne - ligne)
						+ Math.abs(noeudArrivee.colonne - colonne);
			}
		}
	}

	@Override
	public void effacer() {
		listeNoeuds = null;
		listeArcs = null;

		// Effacer les distances et précurseurs
		for (int ligne = 0; ligne < nbLignes; ligne++) {
			for (int colonne = 0; colonne < nbColonnes; colonne++) {
				tuiles[ligne][colonne].distanceDuDepart = Double.POSITIVE_INFINITY;
				tuiles[ligne][colonne].precurseur = null;
			}
		}

		// Noeud initial
		noeudDepart.distanceDuDepart = noeudDepart.Cout();
	}
}
