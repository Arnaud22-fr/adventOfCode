package advent.day10;

import java.util.Collections;
import java.util.List;

public class Day10 {

	public static void main(String[] args) {

		long nb1 = 1;
		long nb3 = 1;

		List<Integer> dataSet = DatasDay10.getEntrees();
		Collections.sort(dataSet);

		for (int i = 0; i < dataSet.size() - 1; i++) {

			System.out.println(dataSet.get(i));
			System.out.println(dataSet.get(i + 1));

			if (dataSet.get(i + 1) - dataSet.get(i) == 1) {
				nb1++;
			} else if (dataSet.get(i + 1) - dataSet.get(i) == 3) {
				nb3++;
			}

		}
		System.out.println(nb1);
		System.out.println(nb3);
		System.out.println(nb1 * nb3);
	}

}
