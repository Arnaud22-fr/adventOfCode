package advent.day8;

import java.util.HashMap;
import java.util.Map;

public class Day8 {

	static int accumulator = 0;
	static boolean stop = false;
	static boolean first = true;
	static int instructionCourante = 0;
	static Map<Integer, String> instructionsExecutees = new HashMap<Integer, String>();

	public static void main(String[] args) {

		String[] dataSet = DatasDay8.entrees2;

		String instruction = dataSet[0];
		instructionsExecutees.put(0, instruction);

		while (!stop) {

			String action = instruction.split(" ")[0];
			String signe = instruction.split(" ")[1].substring(0, 1);
			int nombre = Integer.valueOf(instruction.split(" ")[1].substring(1));

			System.out.println(action + signe + nombre);
			instruction = doAction(dataSet, action, signe, nombre);
			System.out.println(accumulator);

		}

		System.out.println(accumulator);
	}

	private static String doAction(String[] entrees, String action, String signe, int nombre) {

		String instruction = "";

		if (instructionsExecutees.get(instructionCourante) != null && first) {
			if (!first) {
				stop = true;
			}
			first = false;
		}

		if (!stop) {
			switch (action) {
			case "nop":
				instructionCourante = instructionCourante + 1;
				break;
			case "acc":
				instructionCourante = instructionCourante + 1;
				break;
			case "jmp":
				if (signe.equals("+")) {
					instructionCourante = instructionCourante + nombre;
				} else {
					instructionCourante = instructionCourante - nombre;
				}
				break;

			default:
				break;
			}
		}

		if (instructionsExecutees.get(instructionCourante) != null) {
			stop = true;
		}

		if (!stop) {
			switch (action) {
			case "nop":
				instruction = entrees[instructionCourante];
				break;
			case "acc":
				if (signe.equals("+")) {
					accumulator += nombre;
				} else {
					accumulator -= nombre;
				}
				instruction = entrees[instructionCourante];
				break;
			case "jmp":
				if (signe.equals("+")) {
					instruction = entrees[instructionCourante];
				} else {
					instruction = entrees[instructionCourante];
				}
				break;

			default:
				break;
			}

			if (instructionsExecutees.get(instructionCourante) == null) {
				instructionsExecutees.put(instructionCourante, instruction);
			} else {
				stop = true;
			}
		}

		return instruction;

	}

}
