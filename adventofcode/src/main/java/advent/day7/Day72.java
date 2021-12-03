package advent.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Day72 {

	private static final String SHINY_GOLD = "shiny gold";
	private static final String STOP = "no other";
	static int total = 0;

	public static void main(String[] args) {

		int result = 0;
		Map<String, Sac> sacs = new HashMap<String, Sac>();
		List<String> nomSacs = new ArrayList<String>();
		for (String entree : DatasDay7.entrees) {

			String[] nameContenant = entree.split("contain");
			String name = nameContenant[0];
			String[] contenants = nameContenant[1].split(",");

			Map<String, Integer> listeContenant = new HashMap<String, Integer>();
			Sac sac = new Sac();
			sac.setName(name.trim());
			for (String contenant : contenants) {
				if (!contenant.trim().contains(STOP)) {
					listeContenant.put(contenant.trim().substring(1),
							Integer.valueOf(contenant.trim().substring(0, 1)));
				} else {
					listeContenant.put(contenant.trim().substring(1), 0);
				}
			}
//			sac.setContenant(listeContenant);
			sacs.put(sac.getName(), sac);

			nomSacs.add(name.trim());

		}

		List<String> sacUnique = new ArrayList<>(new HashSet<>(nomSacs));

//		result = countShinyGold(sacs);

		System.out.println(result);
	}

//	public static int countShinyGold(Map<String, Integer> map) {
//		if (map.name.equals(SHINY_GOLD)) {
//			total += 1;
//		} else if (map.name.equals(STOP)) {
//			return total;
//		} else {
//			countShinyGold(map.getContenant());
//		}
//	}return total;
//
//	}

//	public List<File> getFilesInFolder(File folder) {
//		List<File> files = new ArrayList<File>();
//		for (File f : folder.listFiles()) {
//			if (f.isDirectory()) // Si c'est un dossier, on ajoute tous ce qui est dans ce dossier
//			{
//				List<File> filesInFolder = getFilesInFolder(f); // On récupère tout les fichiers (avec cette fonction,
//																// comme ça on a aussi tout les sous-dossier, ...)
//				files.addAll(filesInFolder); // On les ajoute à note list de départ
//			} else {
//				files.add(f); // Si c'est un fichier on l'ajoute
//			}
//		}
//
//		return files; // Le tour est joué !
//	}

//	public Map<String, Integer> countShinyGoldInSac(Map<String, Integer> map) {
//		List<File> files = new ArrayList<File>();
//		for (File f : folder.listFiles()) {
//			if (f.isDirectory()) // Si c'est un dossier, on ajoute tous ce qui est dans ce dossier
//			{
//				List<File> filesInFolder = getFilesInFolder(f); // On récupère tout les fichiers (avec cette fonction,
//																// comme ça on a aussi tout les sous-dossier, ...)
//				files.addAll(filesInFolder); // On les ajoute à note list de départ
//			} else {
//				files.add(f); // Si c'est un fichier on l'ajoute
//			}
//		}
//
//		return files; // Le tour est joué !
//	}

}
