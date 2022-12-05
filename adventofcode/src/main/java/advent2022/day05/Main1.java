package advent2022.day05;

public class Main1 {

	public static void main(String[] args) {

		String[] stack1 = Datas.getEntrees().get(0).split(",");
		String[] stack2 = Datas.getEntrees().get(1).split(",");
		String[] stack3 = Datas.getEntrees().get(2).split(",");
		String[] stack4 = Datas.getEntrees().get(3).split(",");
		String[] stack5 = Datas.getEntrees().get(4).split(",");
		String[] stack6 = Datas.getEntrees().get(5).split(",");
		String[] stack7 = Datas.getEntrees().get(6).split(",");
		String[] stack8 = Datas.getEntrees().get(7).split(",");
		String[] stack9 = Datas.getEntrees().get(8).split(",");

		String[][] stacks = { stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9 };

		for (String entree : Datas.getEntreesMvt()) {

			String[] instruction = entree.split(",");

			int move = Integer.valueOf(instruction[0]);
			int from = Integer.valueOf(instruction[1]);
			int to = Integer.valueOf(instruction[2]);

			String newArrTo[] = new String[stacks[to - 1].length + move];
			for (int i = 0; i < stacks[to - 1].length; i++) {
				newArrTo[i] = stacks[to - 1][i];
			}
			for (int i = 0; i < move; i++) {
				newArrTo[stacks[to - 1].length + i] = stacks[from - 1][stacks[from - 1].length - 1 - i];
			}
			String newArrFrom[] = new String[stacks[from - 1].length - move];
			for (int i = 0; i < stacks[from - 1].length - move; i++) {
				newArrFrom[i] = stacks[from - 1][i];
			}

			stacks[from - 1] = newArrFrom;
			stacks[to - 1] = newArrTo;
			System.out.println("debug");
		}

		String top = "";
		for (int i = 0; i < stacks.length; i++) {
			if (stacks[i][stacks[i].length - 1] != "") {
				top += stacks[i][stacks[i].length - 1];
			}
		}
		System.out.println(top);
	}

}
