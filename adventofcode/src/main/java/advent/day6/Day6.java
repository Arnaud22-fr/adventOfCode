package advent.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {

	public static void main(String[] args) {

		int result = 0;
		String allResponse = "";

		List<String> questions = new ArrayList<String>();

		for (String entree : DatasDay6.entrees) {

			// Si chaine non vide => on comptabilise les réponses de la personne
			if (!"".equals(entree)) {
				allResponse += entree;
			}

			if ("".equals(entree)) {
				allResponse = removeDups(allResponse);
				result += allResponse.length();
				questions.clear();
				allResponse = "";
			}

		}
		allResponse = removeDups(allResponse);
		result += allResponse.length();
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

}
