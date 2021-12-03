package advent2021.day1;

public class Main1 {

	public static void main(String[] args) {

		Integer result = 0;
		Integer profondeurPrecedent = 0;

		for (Integer entree1 : Datas.getEntrees()) {

			if (profondeurPrecedent != 0) {
				if (entree1 > profondeurPrecedent) {
					result++;
				}
			}

			profondeurPrecedent = entree1;
		}
		System.out.println(result);
	}

}
