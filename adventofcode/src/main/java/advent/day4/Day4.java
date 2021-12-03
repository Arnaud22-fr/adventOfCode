package advent.day4;

public class Day4 {

	public static void main(String[] args) {

		Passport passport = new Passport();
		int result = 0;
		boolean premierPassport = true;
		boolean nouveauPassport = true;

		for (String entree : DatasDay4.entrees) {

			if (premierPassport || "".equals(entree)) {
				premierPassport = false;
				nouveauPassport = true;
			} else {
				nouveauPassport = false;
			}

			// Si chaine vide => nouveau passport : on ne fait rien
			if (!"".equals(entree)) {
				String[] entrees = entree.split(" ");

				for (String element : entrees) {

					String[] key = element.split(":");

					switch (key[0]) {
					case "cid":
						passport.setCid(key[1]);
						break;
					case "ecl":
						passport.setEcl(key[1]);
						break;
					case "pid":
						passport.setPid(key[1]);
						break;
					case "eyr":
						passport.setEyr(key[1]);
						break;
					case "hcl":
						passport.setHcl(key[1]);
						break;
					case "byr":
						passport.setByr(key[1]);
						break;
					case "iyr":
						passport.setIyr(key[1]);
						break;
					case "hgt":
						passport.setHgt(key[1]);
						break;

					default:
						break;
					}
				}

			}

			if (nouveauPassport && !premierPassport) {
				if (passport.isValid()) {
					result += 1;
				}
				passport.clear();
			}

		}
		System.out.println(result);
	}

}
