package advent2021.day2;

public class Main2 {

	public static void main(String[] args) {

		int aim = 0;
		int horizontal = 0;
		int depth = 0;

		for (String entree : Datas.getEntrees()) {
			String values[] = entree.split(" ");
			switch (values[0]) {
			case "forward":
				horizontal += Integer.valueOf(values[1]);
				depth += aim * Integer.valueOf(values[1]);
				break;
			case "down":
				aim += Integer.valueOf(values[1]);
				break;
			case "up":
				aim -= Integer.valueOf(values[1]);
				break;

			default:
				break;
			}
		}
		System.out.println(horizontal * depth);
	}

}
