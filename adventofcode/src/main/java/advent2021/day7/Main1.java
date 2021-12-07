package advent2021.day7;

public class Main1 {

	public static void main(String[] args) {

//		int[] datas = Datas.getDatastest();
		int[] datas = Datas.getDatas();

		int coutDeplacementMin = Integer.MAX_VALUE;

		for (int cout = 0; cout < datas.length; cout++) {
			int coutDeplacement = 0;
			for (int position : datas) {
				coutDeplacement += Math.abs(position - cout);
			}
			if (coutDeplacement < coutDeplacementMin) {
				coutDeplacementMin = coutDeplacement;
			}
		}

		System.out.println(coutDeplacementMin);
	}

}
