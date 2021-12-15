package advent2021.day15;

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

	// Lancement sur les deux problèmes
	private void lancer() {
		// Cas 1ère carte
		Carte carte1 = new Carte(datasTest, 0, 0, 9, 9);
		LancerAlgorithmes(carte1);
		// Cas 2ème carte
		Carte carte2 = new Carte(datas, 0, 0, 99, 99);
		LancerAlgorithmes(carte2);
		// Cas 2eme carte dupliqué 5 fois
		Carte carte3 = dupliquerCarte(datas, 5);
		LancerAlgorithmes(carte3);
	}

	private Carte dupliquerCarte(String[] carte, int nbDuplication) {

		String[] newCarte = new String[carte.length * nbDuplication];
		String[] carte1 = incrementerCarte(carte);
		String[] carte2 = incrementerCarte(carte1);
		String[] carte3 = incrementerCarte(carte2);
		String[] carte4 = incrementerCarte(carte3);
		String[] carte5 = incrementerCarte(carte4);
		String[] carte6 = incrementerCarte(carte5);
		String[] carte7 = incrementerCarte(carte6);
		String[] carte8 = incrementerCarte(carte7);

		for (int ligne = 0; ligne < 100; ligne++) {
			newCarte[ligne] = carte[ligne].concat(carte1[ligne]).concat(carte2[ligne]).concat(carte3[ligne])
					.concat(carte4[ligne]);
		}
		for (int ligne = 100; ligne < 200; ligne++) {
			newCarte[ligne] = carte1[ligne - 100].concat(carte2[ligne - 100]).concat(carte3[ligne - 100])
					.concat(carte4[ligne - 100]).concat(carte5[ligne - 100]);
		}
		for (int ligne = 200; ligne < 300; ligne++) {
			newCarte[ligne] = carte2[ligne - 200].concat(carte3[ligne - 200]).concat(carte4[ligne - 200])
					.concat(carte5[ligne - 200]).concat(carte6[ligne - 200]);
		}
		for (int ligne = 300; ligne < 400; ligne++) {
			newCarte[ligne] = carte3[ligne - 300].concat(carte4[ligne - 300]).concat(carte5[ligne - 300])
					.concat(carte6[ligne - 300]).concat(carte7[ligne - 300]);
		}
		for (int ligne = 400; ligne < 500; ligne++) {
			newCarte[ligne] = carte4[ligne - 400].concat(carte5[ligne - 400]).concat(carte6[ligne - 400])
					.concat(carte7[ligne - 400]).concat(carte8[ligne - 400]);
		}

		System.out.println(newCarte[0].length());
		return new Carte(newCarte, 0, 0, 499, 499);
	}

	private String[] incrementerCarte(String[] carte) {
		String[] newCarte = new String[carte.length];
		int id = 0;
		for (String ligne : newCarte) {
			newCarte[id] = carte[id];
			id++;
		}

		for (int v = 9; v >= 0; v--) {
			if (v == 9) {
				int i = 0;
				for (String ligne : newCarte) {
					newCarte[i] = ligne.replace("9", "0");
					i++;
				}
			} else if (v == 0) {
				int i = 0;
				for (String ligne : newCarte) {
					newCarte[i] = ligne.replace("0", "1");
					i++;
				}
			} else {
				int i = 0;
				for (String ligne : newCarte) {
					newCarte[i] = ligne.replace("" + v, "" + (v + 1));
					i++;
				}
			}
		}
		return newCarte;
	}

	// Lancement de tous les algorithmes à la suite
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

		// Création de l'algorithme
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

		// Résolution
		System.out.println("Algorithme : " + nom);
		debut = LocalDateTime.now();
		algo.resoudre();
		fin = LocalDateTime.now();
		duree = Duration.between(debut, fin);
		System.out.println("Durée (ms) : " + duree.toMillis() + "\n");
	}

	@Override
	public void AfficherResultat(String chemin, double distance) {
		System.out.println("Chemin (taille : " + distance + ") : " + chemin);
	}
}