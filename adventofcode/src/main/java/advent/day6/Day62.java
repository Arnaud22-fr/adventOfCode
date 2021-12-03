package advent.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day62 {

	static Map<Character, Integer> verification = new HashMap<>();

	public static void main(String[] args) {

		int result = 0;
		String allResponse = "";
		initializeMap();

//		Character a = 'a';
//		System.out.println(Character.getNumericValue(a));
//		System.out.println(Character.getNumericValue('b'));
//		System.out.println(Character.getNumericValue('c'));
//		System.out.println(Character.getNumericValue('x'));
//		System.out.println(Character.getNumericValue('y'));
//		System.out.println(Character.getNumericValue('z'));

		List<String> questions = new ArrayList<String>();

		for (String entree : DatasDay6.entrees) {

			// Si chaine non vide => on comptabilise les réponses de la personne
			if (!"".equals(entree)) {
				questions.add(entree);
			}

			if ("".equals(entree)) {

				for (String question : questions) {
					for (int i = 0; i < question.length(); i++) {
						verification.put(question.charAt(i), 1 + verification.get(question.charAt(i)));
					}
				}
				for (int i = 0; i < verification.size(); i++) {
					if (verification.get((char) (i + 97)) == questions.size()) {
						result += 1;
					}
				}
				questions.clear();
				initializeMap();
			}

		}

		for (String question : questions) {
			for (int i = 0; i < question.length(); i++) {
				verification.put(question.charAt(i), 1 + verification.get(question.charAt(i)));
			}
		}
		for (int i = 0; i < verification.size(); i++) {
			if (verification.get((char) (i + 97)) == questions.size()) {
				result += 1;
			}
		}
		System.out.println(result);
	}

	public static String removeDups(String word) {
		Set<Character> chars = new HashSet<>();
		StringBuilder output = new StringBuilder(word.length());

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (chars.add(ch)) {
				output.append(ch);
			}
		}

		return output.toString();
	}

	private static void initializeMap() {

		verification.clear();

		verification.put('a', 0);
		verification.put('b', 0);
		verification.put('c', 0);
		verification.put('d', 0);
		verification.put('e', 0);
		verification.put('f', 0);
		verification.put('g', 0);
		verification.put('h', 0);
		verification.put('i', 0);
		verification.put('j', 0);
		verification.put('k', 0);
		verification.put('l', 0);
		verification.put('m', 0);
		verification.put('n', 0);
		verification.put('o', 0);
		verification.put('p', 0);
		verification.put('q', 0);
		verification.put('r', 0);
		verification.put('s', 0);
		verification.put('t', 0);
		verification.put('u', 0);
		verification.put('v', 0);
		verification.put('w', 0);
		verification.put('x', 0);
		verification.put('y', 0);
		verification.put('z', 0);
	}

}
