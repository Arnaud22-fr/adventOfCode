package advent2022.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {

	public static void main(String[] args) {

		int total = 0;

		for (String entree : Datas.getEntrees()) {

			String[] entreeSplit = entree.split(",");

			List<Integer> first = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[0]),
					Integer.valueOf(entreeSplit[1]));
			List<Integer> second = getNumbersUsingIntStreamRangeClosed(Integer.valueOf(entreeSplit[2]),
					Integer.valueOf(entreeSplit[3]));

			List<Integer> union = intersection(first, second);
			if (union.size() != 0) {
				total += 1;
			}

		}
		System.out.println(total);
	}

	public static List<Integer> getNumbersUsingIntStreamRangeClosed(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
	}

	public static <T> List<T> intersection(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();

		for (T t : list1) {
			if (list2.contains(t)) {
				list.add(t);
			}
		}

		return list;
	}

}
