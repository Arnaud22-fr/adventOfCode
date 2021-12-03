package advent.day7;

import java.util.ArrayList;
import java.util.List;

public class Day7 {

	private static final String SHINY_GOLD = "shiny gold";
	private static final String NO_OTHER = "no other";
	static int total = 0;
	static int tmpResult;
	static List<Regle> regles = new ArrayList<>();
	static boolean regleShiny = false;

	public static void main(String[] args) {

		for (String entree : DatasDay7.entrees) {

			Regle regle = new Regle();

			String[] nameContenant = entree.split("contain");
			String[] contenants = nameContenant[1].split(",");

			regle.setSac(nameContenant[0].trim());
			regle.setShinyGold(0);

			List<String> listeSac = new ArrayList<String>();
			for (String contenant : contenants) {
				if (!contenant.trim().contains(NO_OTHER)) {
					listeSac.add(contenant.trim().substring(1).trim());
				} else {
					listeSac.add(contenant.trim().substring(0).trim());
				}
				if (contenant.contains(SHINY_GOLD)) {
//					System.out.println("shiny dans ce sac ! " + contenant);
					regle.setShinyGold(1);
					regle.setShiny(true);
				}
			}

			regle.setSacs(listeSac);
			regles.add(regle);

		}
		for (Regle regle : regles) {
			regleShiny = false;
//			if (!regle.sac.equalsIgnoreCase(SHINY_GOLD)) {
			isItShiny(regle);
//			}
			if (regleShiny) {
				regle.setShiny(true);
			}

		}

		int total2 = 0;
		for (Regle regle : regles) {
//			if (!regle.sac.equalsIgnoreCase(SHINY_GOLD)) {
			if (regle.isShiny) {
				total2 += 1;
			}
//			}

		}

		System.out.println(total2);
//		System.out.println(total);
	}

	private static void isItShiny(Regle regle) {

		if (regle != null) {
			for (String contenant : regle.getSacs()) {
				if (contenant.equalsIgnoreCase(SHINY_GOLD)) {
					regleShiny = true;
				} else {
					isItShiny(getRegle(contenant));
				}
			}
		}

	}

	private static int isShiny(Regle regle) {

		if (tmpResult == 0) {

			for (String contenant : regle.getSacs()) {
				if (contenant.equalsIgnoreCase(SHINY_GOLD)) {
					tmpResult += 1;
					regle.setShinyGold(1);
					break;
				}
			}

			if (tmpResult == 0) {

				for (String contenant : regle.getSacs()) {
//					System.out.println("test de " + contenant);
					if (contenant.equalsIgnoreCase(SHINY_GOLD)) {
						tmpResult += 1;
						regle.setShinyGold(1);
						break;
					} else if (contenant.equalsIgnoreCase(NO_OTHER)) {
						regle.setShinyGold(0);
					} else {
						if (tmpResult == 0) {
							isShiny(getRegle(contenant));
						}
					}
				}
			}
		}

		return tmpResult;
	}

	private static Regle getRegle(String sac) {
		for (Regle regle : regles) {
			if (regle.sac.equals(sac)) {
//				System.out.println("règle intermédiaire : " + regle);
				return regle;
			}
		}
		return null;
	}

}
