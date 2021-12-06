package advent2021.day6;

public class Main1BU {

	private static final int NB_JOUR = 80;

	public static void main(String[] args) {

		int[] datas = Datas.getDatastest();
//		int[] datas = Datas.getDatas();

		Integer result = 0;
		int[] hier = datas;
		int naissance = 0;

		for (int jour = 0; jour < NB_JOUR; jour++) {

			naissance = 0;
			for (int fish = 0; fish < hier.length; fish++) {

				if (hier[fish] == 0) {
					naissance++;
				}
			}

			int[] aujourdhui = new int[hier.length + naissance];
//			afficherDebug(hier);

			for (int fish = 0; fish < hier.length; fish++) {
				if (hier[fish] == 0) {
					aujourdhui[fish] = 6;
				} else {
					aujourdhui[fish] = hier[fish] - 1;
				}

			}
			for (int n = hier.length; n < hier.length + naissance; n++) {
				aujourdhui[n] = 8;
			}
			hier = new int[aujourdhui.length];
			hier = aujourdhui;

		}

		result = hier.length;

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
