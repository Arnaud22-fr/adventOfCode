package advent2022.day11;

import java.util.Arrays;
import java.util.List;

public class Datas {

	public final static List<String> monkeysTest = Arrays.asList("0;79,98;23;2;3", "1;54,65,75,74;19;2;0",
			"2;79,60,97;13;1;3", "3;74;17;0;1");
	public final static List<String> monkeys = Arrays.asList("0;59,65,86,56,74,57,56;3;3;6", "1;63,83,50,63,56;13;3;0",
			"2;93,79,74,55;2;0;1", "3;86,61,67,88,94,69,56,91;11;6;7", "4;76,50,51;19;2;5", "5;77,76;17;2;1",
			"6;74;5;4;7", "7;86,85,52,86,91,95;7;4;5");

	public static List<String> getInstructions() {
		return monkeysTest;
	}

	public static List<String> getInstructionsTest() {
		return monkeys;
	}

}
