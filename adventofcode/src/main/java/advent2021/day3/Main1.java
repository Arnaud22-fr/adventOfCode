package advent2021.day3;

import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) {

		int zeros[] = new int[12];
		Arrays.fill(zeros, 0);
		int uns[] = new int[12];
		Arrays.fill(uns, 0);

		for (String entree : Datas.getEntrees()) {
			char[] x = entree.toCharArray();
			for (int i = 0; i < 12; i++) {
				if (x[i] == '1') {
					uns[i] = uns[i] + 1;
				} else {
					zeros[i] = zeros[i] + 1;
				}
			}
		}

		int gamaI = 0;
		int epsilonI = 0;

		for (int i = 0; i < 12; i++) {
			if (zeros[i] > uns[i]) {
				epsilonI += Math.pow(2, 11 - i);

			} else {
				gamaI += Math.pow(2, 11 - i);
			}
		}
		System.out.println(gamaI * epsilonI);

	}

}
