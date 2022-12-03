package advent2022.day02;

public class Main1 {

	public static void main(String[] args) {

		int total = 0;

		for (String entree : Datas.getEntrees()) {

			total += Valeur.valueOf(entree).getValeur() + Valeur.valueOf(entree.substring(1)).getValeur();

		}
		System.out.println(total);
	}

	public enum Valeur {
		A(1), B(2), C(3), //
		X(1), Y(2), Z(3), //
		AX(3), AY(6), AZ(0), BX(0), BY(3), BZ(6), CX(6), CY(0), CZ(3);

		private final int valeur;

		private Valeur(int valeur) {
			this.valeur = valeur;
		}

		public int getValeur() {
			return this.valeur;
		}
	}

}
