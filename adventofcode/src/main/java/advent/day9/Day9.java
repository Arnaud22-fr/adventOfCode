package advent.day9;

public class Day9 {

	public static void main(String[] args) {

		long result = 0;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;

		long magicNumber = 57195069L;

		for (int i = 0; i < DatasDay9.entrees.length; i++) {

			result = 0;
			min = Long.MAX_VALUE;
			max = Long.MIN_VALUE;

			int j = i;

			while (result < magicNumber) {

				if (DatasDay9.entrees[j] < min) {
					min = DatasDay9.entrees[j];
				}
				if (DatasDay9.entrees[j] > max) {
					max = DatasDay9.entrees[j];
				}
				result += DatasDay9.entrees[j];
				j++;
				if (result == magicNumber) {
					System.out.println(DatasDay9.entrees[i] + ";" + DatasDay9.entrees[j]);
					System.out.println(min + max);

				}

			}

		}
//		System.out.println(reponse);
	}

}
