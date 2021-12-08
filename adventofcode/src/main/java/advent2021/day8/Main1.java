package advent2021.day8;

import java.util.List;

public class Main1 {

	public static void main(String[] args) {

//		List<String> datas = Datas.getDatastest();
		List<String> datas = Datas.getDatas();

		int result = 0;

		for (String entree : datas) {
			String paires[] = entree.split(" \\| ");
			String sol1 = paires[1].split(" ")[0];
			int sol1int = sol1.length();
			String sol2 = paires[1].split(" ")[1];
			int sol2int = sol2.length();
			String sol3 = paires[1].split(" ")[2];
			int sol3int = sol3.length();
			String sol4 = paires[1].split(" ")[3];
			int sol4int = sol4.length();

			if (sol1int == 2 || sol1int == 3 || sol1int == 4 || sol1int == 7) {
				result++;
			}
			if (sol2int == 2 || sol2int == 3 || sol2int == 4 || sol2int == 7) {
				result++;
			}
			if (sol3int == 2 || sol3int == 3 || sol3int == 4 || sol3int == 7) {
				result++;
			}
			if (sol4int == 2 || sol4int == 3 || sol4int == 4 || sol4int == 7) {
				result++;
			}

		}
		System.out.println(result);
	}

}
