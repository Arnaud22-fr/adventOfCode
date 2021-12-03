package advent.day9;

import java.util.HashMap;
import java.util.Map;

public class Day92 {

	public static void main(String[] args) {

		long reponse = 0L;
		int index = 0;
		int taillePool = 25;

		Map<Long, Boolean> verif = new HashMap<Long, Boolean>();

		for (Long entree : DatasDay9.entrees) {
			verif.put(entree, false);
		}

//		List<Long> listWithDuplicates = new ArrayList<Long>();

		for (int i = index; i < DatasDay9.entrees.length - 2 * taillePool; i++) {

			long[][] datas = DatasDay9.getDatas(i, taillePool);

			for (int j = 0; j < taillePool; j++) {

				for (int k = 0; k < taillePool; k++) {

					for (int l = 0; l < taillePool; l++) {

						if (datas[1][j] == datas[0][k] + datas[0][l]) {
//							System.out.println(datas[1][j] + " OK");
//							listWithDuplicates.add(datas[1][j]);
							verif.put(datas[1][j], true);

						}

					}
				}

			}

		}

		for (Long entree : DatasDay9.entrees) {
			System.out.println(verif.get(entree) + " : " + entree);
		}

//		List<Long> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

//		System.out.println(reponse);
	}

}
