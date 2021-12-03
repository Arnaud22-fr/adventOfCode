package advent2021.day2;

public class Main1 {

	public static void main(String[] args) {

		int forward = 0;
		int depth = 0;

		for (String entree : Datas.getEntrees()) {
			String values[] = entree.split(" ");
			switch (values[0]) {
			case "forward":
				forward += Integer.valueOf(values[1]);
				break;
			case "down":
				depth += Integer.valueOf(values[1]);
				break;
			case "up":
				depth -= Integer.valueOf(values[1]);
				break;

			default:
				break;
			}
		}
		System.out.println(forward * depth);
	}

}
