package advent.day12;

import java.util.List;

public class Day12 {

//	static List<String> dataSet = DatasDay12.getExemple();
	static List<String> dataSet = DatasDay12.getEntrees();

	static String face = "E";
	static int faceOrientation = 90;
	static int nord = 0;
	static int sud = 0;
	static int est = 0;
	static int ouest = 0;

	public static void main(String[] args) {

		for (String instruction : dataSet) {
			System.out.println("face " + face + " faceOrientation " + faceOrientation + " nord " + nord + " sud " + sud
					+ " est " + est + " ouest " + ouest);
			System.out.println("instruction " + instruction);

			String action = instruction.substring(0, 1);
			int value = Integer.valueOf(instruction.substring(1));

			switch (action) {
			case "N":
				nord += value;
				break;
			case "S":
				sud += value;
				break;
			case "E":
				est += value;
				break;
			case "W":
				ouest += value;
				break;

			case "L":

				faceOrientation = (faceOrientation - value) % 360;
				System.out.println("nouvelle orientation " + faceOrientation);
				if (faceOrientation == -270) {
					faceOrientation = 90;
				}
				if (faceOrientation == -90) {
					faceOrientation = 270;
				}
				if (faceOrientation == -180) {
					faceOrientation = 180;
				}
				switch (faceOrientation) {
				case 0:
					face = "N";
					break;
				case 90:
					face = "E";
					break;
				case 180:
					face = "S";
					break;
				case 270:
					face = "W";
					break;

				default:
					break;
				}

				break;
			case "R":
				faceOrientation = (faceOrientation + value) % 360;
				if (faceOrientation == -270) {
					faceOrientation = 90;
				}
				if (faceOrientation == -90) {
					faceOrientation = 270;
				}
				if (faceOrientation == -180) {
					faceOrientation = 180;
				}
				System.out.println("nouvelle orientation " + faceOrientation);
				switch (faceOrientation) {
				case 0:
					face = "N";
					break;
				case 90:
					face = "E";
					break;
				case 180:
					face = "S";
					break;
				case 270:
					face = "W";
					break;

				default:
					break;
				}

				break;

			case "F":
				switch (face) {
				case "N":
					nord += value;
					break;
				case "S":
					sud += value;
					break;
				case "E":
					est += value;
					break;
				case "W":
					ouest += value;
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}

		}
		System.out.println("faceOrientation " + faceOrientation);
		System.out.println("face " + face);
		System.out.println("nord " + nord);
		System.out.println("sud " + sud);
		System.out.println("est " + est);
		System.out.println("ouest " + ouest);
		System.out.println(
				Math.abs(Math.abs(Math.abs(nord) - Math.abs(sud)) + Math.abs(Math.abs(ouest) - Math.abs(est))));
	}

}
