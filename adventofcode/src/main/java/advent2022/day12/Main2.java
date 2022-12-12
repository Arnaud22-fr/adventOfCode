package advent2022.day12;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main2 implements IHM {
	static String[] datasTest = Datas.getDataTest();
	static String[] datas = Datas.getData();

	public static void main(String[] args) {
		System.out.println("Recherche de chemins");
		Main2 app = new Main2();
		app.lancer();
	}

	// Lancement sur les deux problèmes
	private void lancer() {
		// Cas 1ère carte
		for (int ligne = 0; ligne < datas.length; ligne++) {
			for (int colonne = 0; colonne < datas[0].length(); colonne++) {
				if (datas[ligne].charAt(colonne) == 'a') {
//					Carte carte1 = new Carte(datasTest, ligne, colonne, 2, 5);
					Carte carte1 = new Carte(datas, ligne, colonne, 20, 148);
					LancerAlgorithmes(carte1);
				}
			}
		}

	}

	// Lancement de tous les algorithmes � la suite
	private void LancerAlgorithmes(Graphe graphe) {
		lancerAlgorithme("Bellman-Ford", graphe);
		lancerAlgorithme("Dijkstra", graphe);
		lancerAlgorithme("A*", graphe);
	}

	private void lancerAlgorithme(String nom, Graphe graphe) {
		// Initialisation
		LocalDateTime debut;
		LocalDateTime fin;
		Duration duree;
		Algorithme algo = null;

		// Cr�ation de l'algorithme
		switch (nom) {
		case "Bellman-Ford":
			algo = new BellmanFord(graphe, this);
			break;
		case "Dijkstra":
			algo = new Dijkstra(graphe, this);
			break;
		case "A*":
			algo = new AStar(graphe, this);
			break;
		}

		// R�solution
		System.out.println("Algorithme : " + nom);
		debut = LocalDateTime.now();
		algo.resoudre();
		fin = LocalDateTime.now();
		duree = Duration.between(debut, fin);
		System.out.println("Dur�e (ms) : " + duree.toMillis() + "\n");
	}

	@Override
	public void AfficherResultat(String chemin, double distance) {
		System.out.println("Chemin (taille : " + distance + ") : " + chemin);
	}
}