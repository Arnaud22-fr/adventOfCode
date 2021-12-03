package advent.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day82 {

	static int accumulator = 0;
	static boolean stop = false;
	static boolean end = false;
	static boolean first = true;
	static int instructionCourante = 0;
	static Map<Integer, String> instructionsExecutees = new HashMap<Integer, String>();

	public static void main(String[] args) {

		String[] dataSet = DatasDay8.entrees2;
		List<String[]> dataSets = new ArrayList<String[]>();

		int indexPrecedent = 0;
		// Construction des 279 dataSet
		for (int i = 0; i < 279; i++) {

			int instruction = 0;
			boolean fait = false;

			String[] dataSetTmp = new String[dataSet.length];
			for (String entree : dataSet) {

				String action = entree.split(" ")[0];
				if (!fait) {
					if (action.matches("nop") || action.matches("jmp")) {
						if (instruction > indexPrecedent) {
							if (action.matches("nop")) {
								entree = entree.substring(0, 3).replaceAll("nop", "jmp") + entree.substring(3);
								indexPrecedent = instruction;
								fait = true;
							}
							if (action.matches("jmp")) {
								entree = entree.substring(0, 3).replaceAll("jmp", "nop") + entree.substring(3);
								indexPrecedent = instruction;
								fait = true;
							}
						}
					}
				}
				dataSetTmp[instruction] = entree;
				instruction++;
			}
			dataSets.add(dataSetTmp);
		}

		for (String[] datas : dataSets) {
			System.out.println("=========== Nouveau DataSet ===============");
			String instruction = datas[0];
			instructionsExecutees.clear();
			instructionsExecutees.put(0, instruction);
			stop = false;
			accumulator = 0;
			instructionCourante = 0;

			while (!stop) {

				String action = instruction.split(" ")[0];
				String signe = instruction.split(" ")[1].substring(0, 1);
				int nombre = Integer.valueOf(instruction.split(" ")[1].substring(1));

				System.out.println(action + signe + nombre);
				instruction = doAction(datas, action, signe, nombre);
				System.out.println(accumulator);

			}
			if (end) {
				System.out.println("end " + accumulator);
				break;
			}
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
		if (instructionCourante == 0 && !stop) {
			end = true;
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
					System.out.println("end " + accumulator);
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
