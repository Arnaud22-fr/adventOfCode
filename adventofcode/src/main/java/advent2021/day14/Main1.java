package advent2021.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
//	static String datas = Datas.getDataTest();
	static String datas = Datas.getData();
	static boolean isDataTest = false;

	public static void main(String[] args) throws Exception {

		String newChaine = datas.substring(0, 1);
		String chaine = datas;
		for (int i = 0; i < 40; i++) {
			System.out.println("itération > " + i);
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
		List<String> codes = new ArrayList<String>();
		if (isDataTest) {
			codes = TransfoTest.getAllCode();
		} else {
			codes = Transfo.getAllCode();
		}
		codes.addAll(Arrays.asList(datas.split("")));
		codes = codes.stream().distinct().collect(Collectors.toList());
		int min = Integer.MAX_VALUE;
		String codeMin = "";
		int max = 0;
		String codeMax = "";
		for (String code : codes) {
			if (chaine.contains(code)) {
				int nb = compterOccurrences(chaine, code.charAt(0));
				if (nb > max) {
					max = nb;
					codeMax = code;
				}
				if (nb < min) {
					min = nb;
					codeMin = code;
				}
			}
		}
		System.out.println("nombre de " + codeMax + " : " + max);
		System.out.println("nombre de " + codeMin + " : " + min);

		System.out.println(max - min);

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