package advent2022.day07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Main1 {

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
						} else {
							dico.put(folderToUpdate, tailleFichier);
						}
						if (!"/".equalsIgnoreCase(folderToUpdate)) {
							folderToUpdate = folderToUpdate.substring(0, folderToUpdate.length() - 11);
						}

					} while (!"/".equalsIgnoreCase(folderToUpdate));

				}

			}

		}

		for (Map.Entry<String, Integer> entry : dico.entrySet()) {
			System.out.println(entry.getKey() + ">" + entry.getValue());
			if (entry.getValue() <= 100000) {
				result += entry.getValue();
			}
		}

		System.out.println(result);
	}

}
