package advent2022.day04;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {

	public static void main(String[] args) {

		int total = 0;

		for (String entree : Datas.getEntrees()) {

			String[] entreeSplit = entree.split(",");

			List<Integer> first = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[0]),
					Integer.valueOf(entreeSplit[1]));
			List<Integer> second = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[2]),
					Integer.valueOf(entreeSplit[3]));

			first.removeAll(second);
			if (first.size() == 0) {
				total += 1;
			} else {
				first = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[0]),
						Integer.valueOf(entreeSplit[1]));
				second = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[2]),
						Integer.valueOf(entreeSplit[3]));
				second.removeAll(first);
				if (second.size() == 0) {
					total += 1;
				}
			}

		}
		System.out.println(total);
	}

	public static List<Integer> getNumbersUsingIntStreamRangeClosed(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
	}

}
