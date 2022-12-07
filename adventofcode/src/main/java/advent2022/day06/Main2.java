package advent2022.day06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) {

		int result = 0;
		String entree = Datas.getEntrees();

		for (int i = 0; i < entree.length() - 14; i++) {
			Set<String> mySet = new HashSet<String>(Arrays.asList(entree.substring(i, i + 14).split("")));
			if (mySet.size() == 14) {
				result = i + 14;
				break;
			}
		}

		System.out.println(result);
	}

}
