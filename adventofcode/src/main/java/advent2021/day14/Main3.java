package advent2021.day14;

import java.math.BigInteger;
import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
//	static String datas = Datas.getDataTest();
	static String datas = Datas.getData();
	static boolean isDataTest = true;

	public static void main(String[] args) throws Exception {
		System.out.println(Date.from(Instant.now()));
		System.out.println(polymerisation(100000));
		System.out.println(Date.from(Instant.now()));
	}

	private static String polymerisation(int etape) {
		LinkedHashMap<String, BigInteger> groupes = creerGroupe(datas);
		Map<String, Character> insertionPairs = Transfo.getMap();

		for (int i = 0; i < etape; i++) {
			groupes = polymerisation(groupes, insertionPairs);
		}

		Map<Character, BigInteger> compterCaracteres = compterCaracteres(groupes);

		return String.valueOf(compterCaracteres.values().stream().max(Comparator.naturalOrder()).get()
				.subtract(compterCaracteres.values().stream().min(Comparator.naturalOrder()).get()));
	}

	private static LinkedHashMap<String, BigInteger> creerGroupe(String entree) {
		LinkedHashMap<String, BigInteger> groupes = new LinkedHashMap<>();

		List<Character> entreeDecoupee = Arrays.stream(entree.split("")).map(s -> s.charAt(0))
				.collect(Collectors.toList());

		for (int i = 0; i < entreeDecoupee.size() - 1; i++) {
			String groupe = new String(new char[] { entreeDecoupee.get(i), entreeDecoupee.get(i + 1) });
			if (groupes.containsKey(groupe)) {
				groupes.put(groupe, groupes.get(groupe).add(BigInteger.ONE));
			} else {
				groupes.put(groupe, BigInteger.ONE);
			}
		}

		return groupes;
	}

	private static Map<Character, BigInteger> compterCaracteres(LinkedHashMap<String, BigInteger> groupes) {
		Map<Character, BigInteger> comptageCaracteres = new HashMap<>();

		for (Map.Entry<String, BigInteger> groupe : groupes.entrySet()) {
			char[] chars = groupe.getKey().toCharArray();

			if (comptageCaracteres.isEmpty()) {
				comptageCaracteres.put(chars[0], groupes.get(groupe.getKey()));
			}

			if (!comptageCaracteres.containsKey(chars[1])) {
				comptageCaracteres.put(chars[1], groupes.get(groupe.getKey()));
			} else {
				comptageCaracteres.put(chars[1], comptageCaracteres.get(chars[1]).add(groupes.get(groupe.getKey())));
			}
		}

		return comptageCaracteres;
	}

	private static LinkedHashMap<String, BigInteger> polymerisation(LinkedHashMap<String, BigInteger> groupes,
			Map<String, Character> insertionPairs) {
		LinkedHashMap<String, BigInteger> nouveauGroupe = new LinkedHashMap<>();

		for (String key : groupes.keySet()) {
			char c = insertionPairs.get(key);
			String premierNouveauGroupe = new String(new char[] { key.charAt(0), c });
			String deuxiemeNouveauGroupe = new String(new char[] { c, key.charAt(1) });

			if (nouveauGroupe.containsKey(premierNouveauGroupe)) {
				nouveauGroupe.put(premierNouveauGroupe, nouveauGroupe.get(premierNouveauGroupe).add(groupes.get(key)));
			} else {
				nouveauGroupe.put(premierNouveauGroupe, groupes.get(key));
			}

			if (nouveauGroupe.containsKey(deuxiemeNouveauGroupe)) {
				nouveauGroupe.put(deuxiemeNouveauGroupe,
						nouveauGroupe.get(deuxiemeNouveauGroupe).add(groupes.get(key)));
			} else {
				nouveauGroupe.put(deuxiemeNouveauGroupe, groupes.get(key));
			}
		}

		return nouveauGroupe;
	}

}