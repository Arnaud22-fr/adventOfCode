package advent2022.day02;

public class Main2 {

	public static void main(String[] args) {

		int total = 0;

		for (String entree : Datas.getEntrees()) {

			total += Valeur.valueOf(Victoire.valueOf(entree).getValeur().toString()).getValeur()
					+ Valeur.valueOf(entree.substring(1)).getValeur();

		}
		System.out.println(total);
	}

	public enum Victoire {
		AX(Valeur.C), BX(Valeur.A), CX(Valeur.B), //
		AY(Valeur.A), BY(Valeur.B), CY(Valeur.C), //
		AZ(Valeur.B), BZ(Valeur.C), CZ(Valeur.A);

		private final Valeur valeur;

		private Victoire(Valeur valeur) {
			this.valeur = valeur;
		}

		public Valeur getValeur() {
			return this.valeur;
		}
	}

	public enum Valeur {
		A(1), B(2), C(3), X(0), Y(3), Z(6);

		private final int valeur;

		private Valeur(int valeur) {
			this.valeur = valeur;
		}

		public int getValeur() {
			return this.valeur;
		}
	}

}
