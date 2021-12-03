package advent2021.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {

		List<String> datas = Datas.getEntrees();
//		List<String> datas = DatasTest.getEntrees();
		int maxIndex = datas.get(0).length();

		List<String> oxygen = new ArrayList<>();
		List<String> co2 = new ArrayList<>();

		List<String> datasCopies = new ArrayList<>();
		datasCopies.addAll(datas);
		oxygen.addAll(datas);
		co2.addAll(datas);
		int idx = 0;

		while (oxygen.size() > 1 || idx > maxIndex - 1) {

			int zeros[] = new int[maxIndex];
			Arrays.fill(zeros, 0);
			int uns[] = new int[maxIndex];
			Arrays.fill(uns, 0);
			for (String entree : datasCopies) {
				char[] x = entree.toCharArray();
				for (int i = 0; i < maxIndex; i++) {
					if (x[i] == '1') {
						uns[i] = uns[i] + 1;
					} else {
						zeros[i] = zeros[i] + 1;
					}
				}
			}
			for (String dataCopie : datasCopies) {
				if (uns[idx] == zeros[idx]) {
					if (dataCopie.charAt(idx) != '1') {
						oxygen.remove(dataCopie);
					}
				} else {
					if (uns[idx] > zeros[idx]) {
						if (dataCopie.charAt(idx) != '1') {
							oxygen.remove(dataCopie);
						}
					} else {
						if (dataCopie.charAt(idx) != '0') {
							oxygen.remove(dataCopie);
						}
					}
				}
			}
			datasCopies.clear();
			datasCopies.addAll(oxygen);
			if (oxygen.size() != 1) {
				idx++;
			}
		}
		if (oxygen.size() == 2) {
			if (oxygen.get(0).charAt(idx) == 1) {
				oxygen.remove(1);
			} else {
				oxygen.remove(0);
			}
		}

		idx = 0;
		datasCopies.clear();
		datasCopies.addAll(datas);
		while (co2.size() > 1 || idx > maxIndex - 1) {

			int zeros[] = new int[maxIndex];
			Arrays.fill(zeros, 0);
			int uns[] = new int[maxIndex];
			Arrays.fill(uns, 0);
			for (String entree : datasCopies) {
				char[] x = entree.toCharArray();
				for (int i = 0; i < maxIndex; i++) {
					if (x[i] == '1') {
						uns[i] = uns[i] + 1;
					} else {
						zeros[i] = zeros[i] + 1;
					}
				}
			}
			for (String dataCopie : datasCopies) {
				if (uns[idx] == zeros[idx]) {
					if (dataCopie.charAt(idx) != '0') {
						co2.remove(dataCopie);
					}
				} else {
					if (uns[idx] > zeros[idx]) {
						if (dataCopie.charAt(idx) != '0') {
							co2.remove(dataCopie);
						}
					} else {
						if (dataCopie.charAt(idx) != '1') {
							co2.remove(dataCopie);
						}
					}
				}
			}
			datasCopies.clear();
			datasCopies.addAll(co2);
			if (co2.size() != 1) {
				idx++;
			}
		}
		if (co2.size() == 2) {
			if (co2.get(0).charAt(idx) == 0) {
				co2.remove(1);
			} else {
				co2.remove(0);
			}
		}

		int oxy = 0;

		for (int i = 0; i < maxIndex; i++) {
			if (oxygen.get(0).charAt(i) == '1') {
				oxy += Math.pow(2, maxIndex - 1 - i);
			}
		}

		int co2Int = 0;

		for (int i = 0; i < maxIndex; i++) {
			if (co2.get(0).charAt(i) == '1') {
				co2Int += Math.pow(2, maxIndex - 1 - i);
			}
		}
		System.out.println(oxy * co2Int);

	}

}
