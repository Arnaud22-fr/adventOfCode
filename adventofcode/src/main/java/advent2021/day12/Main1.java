package advent2021.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main1 {
//	static List<String> datas = Datas.getDataTest();
	static List<String> datas = Datas.getData();
	static boolean part2 = true;

	public static void main(String[] args) throws Exception {
		ArrayList<String> paths1 = genererChemins(!part2);
		System.out.println(paths1.size());
		ArrayList<String> paths2 = genererChemins(part2);
		System.out.println(paths2.size());

	}

	public static ArrayList<String> genererChemins(boolean part2) {
		ArrayList<String> cheminsFinis = new ArrayList<String>();
		Stack<String> cheminsEnCours = new Stack<String>();
		cheminsEnCours.add("start");
		while (cheminsEnCours.size() > 0) {
			String chemin = cheminsEnCours.pop();
			String grotteCourrante = chemin.substring(chemin.lastIndexOf("-") + 1);
			String grottesConnectees = "";
			for (String connection : datas) {
				if (connection.contains(grotteCourrante)) {
					grottesConnectees += connection.replace("-", "").replace(grotteCourrante, "") + " ";
				}
			}
			String[] grottesAccessibles = grottesConnectees.trim().split(" ");
			for (String grotte : grottesAccessibles) {
				if (grotte.equals("start")) {
					continue;
				} else if (grotte.equals("end")) {
					cheminsFinis.add(chemin + "-" + grotte);
				} else if (grotte.equals(grotte.toLowerCase())) {
					if (!chemin.contains(grotte)) {
						cheminsEnCours.add(chemin + "-" + grotte);
					} else if (part2 && !chemin.contains("X:")) {
						cheminsEnCours.add("X:" + chemin + "-" + grotte);
					}
				} else {
					cheminsEnCours.add(chemin + "-" + grotte);
				}
			}
		}

		return cheminsFinis;
	}
}
