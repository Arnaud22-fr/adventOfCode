package advent2021.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolyTraitement implements Runnable {

	static String datas = Datas.getDataTest();
	private String chaine;
	private String name;
	static boolean isDataTest = false;

	public PolyTraitement(String chaine) {
		this.chaine = chaine;
		this.name = chaine;
	}

	@Override
	public void run() {
		System.out.println(chaine);

		String newChaine = chaine.substring(0, 1);
		for (int i = 0; i < 40; i++) {
			String[] elem = chaine.split("");
			for (int idx = 0; idx < chaine.length() - 1; idx++) {
				if (isDataTest) {
					newChaine += TransfoTest.getTransfoTestByCode(elem[idx] + elem[idx + 1]).getText()
							.concat(elem[idx + 1]);
				} else {
					newChaine += Transfo.getTransfoByCode(elem[idx] + elem[idx + 1]).getText().concat(elem[idx + 1]);
				}
			}
			chaine = newChaine;
			newChaine = datas.substring(0, 1);
		}
		System.out.println(chaine);
		List<String> codes = new ArrayList<String>();
		if (isDataTest) {
			codes = TransfoTest.getAllCode();
		} else {
			codes = Transfo.getAllCode();
		}
		codes.addAll(Arrays.asList(datas.split("")));
		codes = codes.stream().distinct().collect(Collectors.toList());
		for (String code : codes) {
			if (chaine.contains(code)) {
				int nb = compterOccurrences(chaine, code.charAt(0));
				System.out.println(name + " > nombre de " + code + " : " + nb);
			}
		}

	}

	public static int compterOccurrences(String maChaine, char recherche) {
		int nb = 0;
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) == recherche)
				nb++;
		}
		return nb;
	}
}
