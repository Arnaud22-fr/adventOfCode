package advent2022.day07;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Main2 {

	public static void main(String[] args) {

		int result = 0;
		List<String> commands = Datas.getCommands();
		String currentFolder = "";
		Map<String, Integer> dico = new HashMap<>();

		for (String command : commands) {

			System.out.println(command);

			if (command.startsWith("$")) {
				switch (command) {
				case "$ cd /": {
					currentFolder = "/";
					break;
				}
				case "$ cd ..": {
					currentFolder = currentFolder.substring(0, currentFolder.length() - 11);
					break;
				}
				case "$ ls": {
					break;
				}
				default:
					currentFolder += StringUtils.leftPad(command.substring(5), 10, '0') + "/";
				}
				System.out.println("currentFolder >" + currentFolder);
			} else {
				if (!command.startsWith("dir")) {

					String folderToUpdate = currentFolder;
					int tailleFichier = Integer.valueOf(command.split(" ")[0]);

					do {
						if (dico.containsKey(folderToUpdate)) {

							int currentFolderSize = dico.get(folderToUpdate);
							currentFolderSize += tailleFichier;
							dico.replace(folderToUpdate, currentFolderSize);
							if ("/".equalsIgnoreCase(folderToUpdate)) {
								break;
							}
						} else {
							dico.put(folderToUpdate, tailleFichier);
						}
						if (!"/".equalsIgnoreCase(folderToUpdate)) {
							folderToUpdate = folderToUpdate.substring(0, folderToUpdate.length() - 11);
						}
						if ("/".equalsIgnoreCase(folderToUpdate)) {
							int currentFolderSize = dico.get(folderToUpdate);
							currentFolderSize += tailleFichier;
							dico.replace(folderToUpdate, currentFolderSize);
						}

					} while (!"/".equalsIgnoreCase(folderToUpdate));

				}

			}

		}

		LinkedHashMap<String, Integer> tri = dico.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		int totalUsed = tri.get("/");
		System.out.println("totalUsed>" + totalUsed);
		int unused = 70000000 - totalUsed;
		System.out.println("freeSpace>" + unused);
		int espaceNeeded = 30000000 - unused;
		System.out.println("espaceNeeded>" + espaceNeeded);

		for (var elem : tri.entrySet()) {
			System.out.println("elem.getValue() >" + elem.getValue());
			if (elem.getValue() > espaceNeeded) {
				result = elem.getValue();
				break;
			}
		}

		System.out.println(result);
	}

}
