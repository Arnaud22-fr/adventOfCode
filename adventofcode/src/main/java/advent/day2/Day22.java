package advent.day2;

public class Day22 {

	public static void main(String[] args) {

		int results = 0;

		for (String entree : DatasDay2.entrees) {

			String[] groupes = entree.split(" ");
			String[] nbs = groupes[0].split("-");
			int min = Integer.parseInt(nbs[0]);
			int max = Integer.parseInt(nbs[1]);

			String letter = groupes[1].substring(0, 1);

			String pw = groupes[2].trim();

			if (pw.substring(min - 1, min).equals(letter) ^ pw.substring(max - 1, max).equals(letter)) {
				results++;
			}

		}

		System.out.println(results);

	}

}
