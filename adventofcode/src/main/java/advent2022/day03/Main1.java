package advent2022.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main1 {

	public static void main(String[] args) {

		int total = 0;

		for (String entree : Datas.getEntrees()) {

			String[] entreeSplit = entree.split("");

			List<String> first = new ArrayList<>(Arrays.asList(entreeSplit).subList(0, (entree.length()) / 2));
			List<String> second = new ArrayList<>(
					Arrays.asList(entreeSplit).subList((entree.length()) / 2, entree.length()));

			Set<String> result = first.stream().distinct().filter(second::contains).collect(Collectors.toSet());
			if (Character.isUpperCase(result.toString().charAt(1))) {
				total += (int) (result.toString().charAt(1)) - 64 + 26;
			} else {
				total += (int) (result.toString().charAt(1)) - 96;
			}
		}
		System.out.println(total);
	}

}
