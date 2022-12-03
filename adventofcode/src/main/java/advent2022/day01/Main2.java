package advent2022.day01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {

		List<Integer> totaux = new ArrayList<>();
		int result = 0;

		for (String entree : Datas.getEntrees()) {

			if (entree != "") {
				result += Integer.valueOf(entree);
			} else {
				totaux.add(result);
				result = 0;
			}

		}
		totaux.sort(Comparator.reverseOrder());
		System.out.println(totaux.get(0) + totaux.get(1) + totaux.get(2));
	}

}
