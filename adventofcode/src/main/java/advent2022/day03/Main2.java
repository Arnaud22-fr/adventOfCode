package advent2022.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main2 {

	public static void main(String[] args) {

		int total = 0;

		List<String> first = new ArrayList<String>();
		List<String> second = new ArrayList<String>();
		List<String> third = new ArrayList<String>();
		Set<String> result = new HashSet<String>();

		int index = 0;

		for (String entree : Datas.getEntrees()) {

			String[] entreeSplit = entree.split("");

			if (index % 3 == 0) {
				first = new ArrayList<>(Arrays.asList(entreeSplit));
			}
			if (index % 3 == 1) {
				second = new ArrayList<>(Arrays.asList(entreeSplit));
			}
			if (index % 3 == 2) {
				third = new ArrayList<>(Arrays.asList(entreeSplit));
				result = first.stream().distinct().filter(second::contains).filter(third::contains)
						.collect(Collectors.toSet());
				index = 0;
				first = new ArrayList<String>();
				second = new ArrayList<String>();
				third = new ArrayList<String>();

				if (Character.isUpperCase(result.toString().charAt(1))) {
					total += (int) (result.toString().charAt(1)) - 64 + 26;
				} else {
					total += (int) (result.toString().charAt(1)) - 96;
				}
				result = new HashSet<String>();
				index = 0;
			} else {
				index++;
			}
		}
		System.out.println(total);
	}

}
