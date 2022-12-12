package advent2022.day12;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main1 implements IHM {
	static String[] datasTest = Datas.getDataTest();
	static String[] datas = Datas.getData();

	public static void main(String[] args) {
		System.out.println("Recherche de chemins");
		Main1 app = new Main1();
		app.lancer();
	}

	// Lancement sur les deux probl�mes
	private void lancer() {
		// Cas 1ère carte
//		Carte carte1 = new Carte(datasTest, 0, 0, 2, 5);
		Carte carte1 = new Carte(datas, 20, 0, 20, 148);
		LancerAlgorithmes(carte1);
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