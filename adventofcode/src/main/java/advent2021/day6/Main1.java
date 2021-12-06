package advent2021.day6;

import java.math.BigDecimal;

public class Main1 {

	private static final int NB_JOUR = 256;

	public static void main(String[] args) {

//		int[] datas = Datas.getDatastest();
		int[] datas = Datas.getDatas();

		BigDecimal result = new BigDecimal("0");
		String[][] groupData = new String[][] { { "0" }, { "0" }, { "0" }, { "0" }, { "0" }, { "0" }, { "0" }, { "0" },
				{ "0" } };
		String[][] groupDataDemain = new String[][] { { "0" }, { "0" }, { "0" }, { "0" }, { "0" }, { "0" }, { "0" },
				{ "0" }, { "0" } };

		for (int fish : datas) {
			switch (fish) {
			case 1:
				groupData[1][0] = (Integer.parseInt(groupData[1][0]) + 1) + "";
				break;
			case 2:
				groupData[2][0] = (Integer.parseInt(groupData[2][0]) + 1) + "";
				break;
			case 3:
				groupData[3][0] = (Integer.parseInt(groupData[3][0]) + 1) + "";
				break;
			case 4:
				groupData[4][0] = (Integer.parseInt(groupData[4][0]) + 1) + "";
				break;
			case 5:
				groupData[5][0] = (Integer.parseInt(groupData[5][0]) + 1) + "";
				break;

			default:
				break;
			}
		}

		for (int jour = 0; jour < NB_JOUR; jour++) {

//			System.out.println(jour);

			for (int group = 0; group < 9; group++) {
				if (group != 8) {
					if (group == 6) {
						groupDataDemain[group][0] = new BigDecimal(groupData[group + 1][0])
								.add(new BigDecimal(groupData[0][0])).toString();
					} else {
						groupDataDemain[group][0] = new BigDecimal(groupData[group + 1][0]).toString();
					}
				} else {
					groupDataDemain[group][0] = groupData[0][0];
				}
			}
			groupData = groupDataDemain;
			groupDataDemain = new String[9][1];

		}
		for (int group = 0; group < 9; group++) {
			result = result.add(new BigDecimal(groupData[group][0]));
		}

		System.out.println(result);
	}

	private static void afficherDebug(int[] hier) {

		String debug = "";
		for (int i = 0; i < hier.length; i++) {
			debug += hier[i];
		}
		System.out.println(debug);
	}

}
