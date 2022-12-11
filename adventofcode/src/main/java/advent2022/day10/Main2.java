package advent2022.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {

		List<Integer> cycles = Arrays.asList(40, 80, 120, 160, 200, 240);
		List<Integer> signalsStrengh = new ArrayList<>(cycles.size());

		int X = 1;

		List<String> dessins = new ArrayList<>(cycles.size());
		String dessin = "";

		int horloge = 0;
		for (String instruction : Datas.getInstructions()) {

			if (cycles.contains(horloge)) {
				System.out.println("debug");
			}

			if (instruction.equalsIgnoreCase("noop")) {

				dessin += X - 1 <= horloge % 40 && horloge % 40 <= X + 1 ? "#" : ".";
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}
			} else {
				int inc = Integer.valueOf(instruction.split(",")[1]);

				dessin += X - 1 <= horloge % 40 && horloge % 40 <= X + 1 ? "#" : ".";
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}

				dessin += X - 1 <= horloge % 40 && horloge % 40 <= X % 40 + 1 ? "#" : ".";
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}
				X += inc;

			}

		}
		System.out.println("X>" + X);

		System.out.println(dessin.substring(0, 39));
		System.out.println(dessin.substring(40, 79));
		System.out.println(dessin.substring(80, 119));
		System.out.println(dessin.substring(120, 159));
		System.out.println(dessin.substring(160, 199));
		System.out.println(dessin.substring(200, 239));

		System.out.println(signalsStrengh.stream().reduce(0, Integer::sum));
	}

}
