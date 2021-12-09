package advent2021.day8;

import java.util.List;

public class Main2 {

	public static void main(String[] args) {

//		List<String> datas = Datas.getDatastest();
		List<String> datas = Datas.getDatastest2();
//		List<String> datas = Datas.getDatas();

		int result = 0;

		for (String entree : datas) {
			String paires[] = entree.split(" \\| ");

			boolean c0 = false;
			boolean c1 = false;
			boolean c2 = false;
			boolean c3 = false;
			boolean c4 = false;
			boolean c5 = false;
			boolean c6 = false;
			boolean c7 = false;
			boolean c8 = false;
			boolean c9 = false;
			String ent0 = "";
			String ent1 = "";
			String ent2 = "";
			String ent3 = "";
			String ent4 = "";
			String ent5 = "";
			String ent6 = "";
			String ent7 = "";
			String ent8 = "";
			String ent9 = "";
			String[] ents = paires[0].split(" ");
			while (ent0.isEmpty() || ent1.isEmpty() || ent2.isEmpty() || ent3.isEmpty() || ent4.isEmpty()
					|| ent5.isEmpty() || ent6.isEmpty() || ent7.isEmpty() || ent8.isEmpty() || ent9.isEmpty()) {
				for (int i = 0; i < ents.length; i++) {

					switch (ents[i].length()) {
					// #1
					case 2:
						ent1 = ents[i];
						c1 = true;
						break;
					// #7
					case 3:
						if (c1) {
							ent7 = ents[i];
							c7 = true;
						}

						break;
					// #4
					case 4:
						if (c7) {
							ent4 = ents[i];
							c4 = true;
						}

						break;
					// #8
					case 7:
						ent8 = ents[i];
						c8 = true;

						break;
					// #2, #5 ,#3
					case 5:
						if (c1) {
							String test3 = ents[i];
							test3 = test3.replaceAll(ent1.substring(0, 1), "");
							test3 = test3.replaceAll(ent1.substring(1), "");
							if (test3.length() == 3) {
								ent3 = ents[i];
								c3 = true;
							}
						}
						if (c9 && ents[i] != ent3) {
							String test = ents[i];
							test = test.replaceAll(ent9.substring(0, 1), "");
							test = test.replaceAll(ent9.substring(1, 2), "");
							test = test.replaceAll(ent9.substring(2, 3), "");
							test = test.replaceAll(ent9.substring(3, 4), "");
							test = test.replaceAll(ent9.substring(4, 5), "");
							test = test.replaceAll(ent9.substring(5, 6), "");
							if (!c5 && test.length() == 0) {
								ent5 = ents[i];
								c5 = true;
							}
							if (!c2 && test.length() == 1) {
								ent2 = ents[i];
								c2 = true;
							}
						}
						break;
					// 0, 6, #9
					case 6:
						if (c3) {
							String test9 = ents[i];
							test9 = test9.replaceAll(ent3.substring(0, 1), "");
							test9 = test9.replaceAll(ent3.substring(1, 2), "");
							test9 = test9.replaceAll(ent3.substring(2, 3), "");
							test9 = test9.replaceAll(ent3.substring(3, 4), "");
							test9 = test9.replaceAll(ent3.substring(4, 5), "");
							if (test9.length() == 1) {
								ent9 = ents[i];
								c9 = true;
							}
						}
						if (c5 && ents[i] != ent9) {
							String test = ents[i];
							test = test.replaceAll(ent5.substring(0, 1), "");
							test = test.replaceAll(ent5.substring(1, 2), "");
							test = test.replaceAll(ent5.substring(2, 3), "");
							test = test.replaceAll(ent5.substring(3, 4), "");
							test = test.replaceAll(ent5.substring(4, 5), "");
							if (!c6 && test.length() == 1) {
								ent6 = ents[i];
								c6 = true;
							}
							if (!c0 && test.length() == 2) {
								ent0 = ents[i];
								c0 = true;
							}
						}
						break;

					default:
						System.out.println("erreur programme");
						break;
					}
				}
			}

			String resultConcat = "";

			for (int i = 0; i < 4; i++) {
				boolean trouve = false;
				String sol = paires[1].split(" ")[i];
				if (!trouve && sol.contains(ent8.substring(0, 1)) && sol.contains(ent8.substring(1, 2))
						&& sol.contains(ent8.substring(2, 3)) && sol.contains(ent8.substring(3, 4))
						&& sol.contains(ent8.substring(4, 5)) && sol.contains(ent8.substring(5, 6))
						&& sol.contains(ent8.substring(6, 7))) {
					resultConcat += 8;
					trouve = true;
				}
				if (!trouve && sol.contains(ent9.substring(0, 1)) && sol.contains(ent9.substring(1, 2))
						&& sol.contains(ent9.substring(2, 3)) && sol.contains(ent9.substring(3, 4))
						&& sol.contains(ent9.substring(4, 5)) && sol.contains(ent9.substring(5, 6))) {
					resultConcat += 9;
					trouve = true;
				}
				if (!trouve && sol.contains(ent6.substring(0, 1)) && sol.contains(ent6.substring(1, 2))
						&& sol.contains(ent6.substring(2, 3)) && sol.contains(ent6.substring(3, 4))
						&& sol.contains(ent6.substring(4, 5)) && sol.contains(ent6.substring(5, 6))) {
					resultConcat += 6;
					trouve = true;
				}
				if (!trouve && sol.contains(ent0.substring(0, 1)) && sol.contains(ent0.substring(1, 2))
						&& sol.contains(ent0.substring(2, 3)) && sol.contains(ent0.substring(3, 4))
						&& sol.contains(ent0.substring(4, 5)) && sol.contains(ent0.substring(5, 6))) {
					resultConcat += 0;
					trouve = true;
				}
				if (!trouve && sol.contains(ent5.substring(0, 1)) && sol.contains(ent5.substring(1, 2))
						&& sol.contains(ent5.substring(2, 3)) && sol.contains(ent5.substring(3, 4))
						&& sol.contains(ent5.substring(4, 5))) {
					resultConcat += 5;
					trouve = true;
				}
				if (!trouve && sol.contains(ent2.substring(0, 1)) && sol.contains(ent2.substring(1, 2))
						&& sol.contains(ent2.substring(2, 3)) && sol.contains(ent2.substring(3, 4))
						&& sol.contains(ent2.substring(4, 5))) {
					resultConcat += 2;
					trouve = true;
				}
				if (!trouve && sol.contains(ent3.substring(0, 1)) && sol.contains(ent3.substring(1, 2))
						&& sol.contains(ent3.substring(2, 3)) && sol.contains(ent3.substring(3, 4))
						&& sol.contains(ent3.substring(4, 5))) {
					resultConcat += 3;
					trouve = true;
				}
				if (!trouve && sol.contains(ent4.substring(0, 1)) && sol.contains(ent4.substring(1, 2))
						&& sol.contains(ent4.substring(2, 3)) && sol.contains(ent4.substring(3, 4))) {
					resultConcat += 4;
					trouve = true;
				}
				if (!trouve && sol.contains(ent7.substring(0, 1)) && sol.contains(ent7.substring(1, 2))
						&& sol.contains(ent7.substring(2, 3))) {
					resultConcat += 7;
					trouve = true;
				}
				if (!trouve && sol.contains(ent1.substring(0, 1)) && sol.contains(ent1.substring(1, 2))) {
					resultConcat += 1;
					trouve = true;
				}
			}

			System.out.println(entree + " > " + resultConcat);
			System.out.println("ent0 > " + ent0);
			System.out.println("ent1 > " + ent1);
			System.out.println("ent2 > " + ent2);
			System.out.println("ent3 > " + ent3);
			System.out.println("ent4 > " + ent4);
			System.out.println("ent5 > " + ent5);
			System.out.println("ent6 > " + ent6);
			System.out.println("ent7 > " + ent7);
			System.out.println("ent8 > " + ent8);
			System.out.println("ent9 > " + ent9);

			result += Integer.parseInt(resultConcat);
		}
		System.out.println(result);
	}

}
