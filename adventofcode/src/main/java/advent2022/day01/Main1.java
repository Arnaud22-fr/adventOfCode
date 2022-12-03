package advent2022.day01;

public class Main1 {

	public static void main(String[] args) {

		int total = 0;
		int result = 0;

		for (String entree : Datas.getEntrees()) {

			if (entree != "") {
				result += Integer.valueOf(entree);
			} else {
				if (result > total) {
					total = result;
				}
				result = 0;
			}

		}
		System.out.println(total);
	}

}
