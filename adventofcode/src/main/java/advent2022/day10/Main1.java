package advent2022.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {

		List<Integer> cycles = Arrays.asList(20, 60, 100, 140, 180, 220);
		List<Integer> signalsStrengh = new ArrayList<>(cycles.size());

		int X = 1;

		int horloge = 0;
		for (String instruction : Datas.getInstructions()) {

			if (cycles.contains(horloge)) {
				System.out.println("debug");
			}

			if (instruction.equalsIgnoreCase("noop")) {
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}
			} else {
				int inc = Integer.valueOf(instruction.split(",")[1]);
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}
				horloge++;
				if (cycles.contains(horloge)) {
					signalsStrengh.add(X * horloge);
				}
				X += inc;

			}

		}
		System.out.println("X>" + X);

		System.out.println(signalsStrengh.stream().reduce(0, Integer::sum));
	}

}
