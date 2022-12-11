package advent2022.day10;

import java.util.Arrays;
import java.util.List;

public class Datas {

	public final static List<String> instructionsTestTiny = Arrays.asList("noop", "addx,3", "addx,-5");

	public final static List<String> instructionsTest = Arrays.asList("addx,15", "addx,-11", "addx,6", "addx,-3",
			"addx,5", "addx,-1", "addx,-8", "addx,13", "addx,4", "noop", "addx,-1", "addx,5", "addx,-1", "addx,5",
			"addx,-1", "addx,5", "addx,-1", "addx,5", "addx,-1", "addx,-35", "addx,1", "addx,24", "addx,-19", "addx,1",
			"addx,16", "addx,-11", "noop", "noop", "addx,21", "addx,-15", "noop", "noop", "addx,-3", "addx,9", "addx,1",
			"addx,-3", "addx,8", "addx,1", "addx,5", "noop", "noop", "noop", "noop", "noop", "addx,-36", "noop",
			"addx,1", "addx,7", "noop", "noop", "noop", "addx,2", "addx,6", "noop", "noop", "noop", "noop", "noop",
			"addx,1", "noop", "noop", "addx,7", "addx,1", "noop", "addx,-13", "addx,13", "addx,7", "noop", "addx,1",
			"addx,-33", "noop", "noop", "noop", "addx,2", "noop", "noop", "noop", "addx,8", "noop", "addx,-1", "addx,2",
			"addx,1", "noop", "addx,17", "addx,-9", "addx,1", "addx,1", "addx,-3", "addx,11", "noop", "noop", "addx,1",
			"noop", "addx,1", "noop", "noop", "addx,-13", "addx,-19", "addx,1", "addx,3", "addx,26", "addx,-30",
			"addx,12", "addx,-1", "addx,3", "addx,1", "noop", "noop", "noop", "addx,-9", "addx,18", "addx,1", "addx,2",
			"noop", "noop", "addx,9", "noop", "noop", "noop", "addx,-1", "addx,2", "addx,-37", "addx,1", "addx,3",
			"noop", "addx,15", "addx,-21", "addx,22", "addx,-6", "addx,1", "noop", "addx,2", "addx,1", "noop",
			"addx,-10", "noop", "noop", "addx,20", "addx,1", "addx,2", "addx,2", "addx,-6", "addx,-11", "noop", "noop",
			"noop");

	public final static List<String> instructions = Arrays.asList("addx,1", "noop", "noop", "noop", "addx,5", "addx,5",
			"noop", "noop", "addx,9", "addx,-5", "addx,1", "addx,4", "noop", "noop", "noop", "addx,6", "addx,-1",
			"noop", "addx,5", "addx,-2", "addx,7", "noop", "addx,3", "addx,-2", "addx,-38", "noop", "noop", "addx,32",
			"addx,-22", "noop", "addx,2", "addx,3", "noop", "addx,2", "addx,-2", "addx,7", "addx,-2", "noop", "addx,3",
			"addx,2", "addx,5", "addx,2", "addx,-5", "addx,10", "noop", "addx,3", "noop", "addx,-38", "addx,1",
			"addx,27", "noop", "addx,-20", "noop", "addx,2", "addx,27", "noop", "addx,-22", "noop", "noop", "noop",
			"noop", "addx,3", "addx,5", "addx,2", "addx,-11", "addx,16", "addx,-2", "addx,-17", "addx,24", "noop",
			"noop", "addx,1", "addx,-38", "addx,15", "addx,10", "addx,-15", "noop", "addx,2", "addx,26", "noop",
			"addx,-21", "addx,19", "addx,-33", "addx,19", "noop", "addx,-6", "addx,9", "addx,3", "addx,4", "addx,-21",
			"addx,4", "addx,20", "noop", "addx,3", "addx,-38", "addx,28", "addx,-21", "addx,9", "addx,-8", "addx,2",
			"addx,5", "addx,2", "addx,-9", "addx,14", "addx,-2", "addx,-5", "addx,12", "addx,3", "addx,-2", "addx,2",
			"addx,7", "noop", "noop", "addx,-27", "addx,28", "addx,-36", "noop", "addx,1", "addx,5", "addx,-1", "noop",
			"addx,6", "addx,-1", "addx,5", "addx,5", "noop", "noop", "addx,-2", "addx,20", "addx,-10", "addx,-3",
			"addx,1", "addx,3", "addx,2", "addx,4", "addx,3", "noop", "addx,-30", "noop");

	public static List<String> getInstructionsTestTiny() {
		return instructionsTestTiny;
	}

	public static List<String> getInstructions() {
		return instructions;
	}

	public static List<String> getInstructionsTest() {
		return instructionsTest;
	}

}
