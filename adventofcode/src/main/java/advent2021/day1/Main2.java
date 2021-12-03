package advent2021.day1;

public class Main2 {

	public static void main(String[] args) {

		Integer result = 0;
		Integer tripletPrecedent = 0;
		Integer profondeurMoins1 = 0;
		Integer profondeurMoins2 = 0;

		for (Integer entree1 : Datas.getEntrees()) {

			if (profondeurMoins1 != 0 && profondeurMoins2 != 0) {
				if (entree1 + profondeurMoins1 + profondeurMoins2 > tripletPrecedent && tripletPrecedent != 0) {
					result++;
				}
			}

			if (profondeurMoins1 != 0 && profondeurMoins2 != 0) {
				tripletPrecedent = entree1 + profondeurMoins1 + profondeurMoins2;
			}
			profondeurMoins2 = profondeurMoins1;
			profondeurMoins1 = entree1;

		}
		System.out.println(result);
	}

}
