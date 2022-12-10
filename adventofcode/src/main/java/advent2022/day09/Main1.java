package advent2022.day09;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class Main1 {

	public static void main(String[] args) {

		int[][] map = new int[1001][1001];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = 0;
			}
		}
		int i = 500;
		int j = 500;
		map[i][j] = 1;

		Pair<Integer, Integer> posHead = Pair.of(i, j);
		Pair<Integer, Integer> posTail = Pair.of(i, j);

		List<String> deplacements = Datas.getDeplacements();

		for (String deplacement : deplacements) {

			String direction = deplacement.split(",")[0];
			int distance = Integer.valueOf(deplacement.split(",")[1]);

			for (int pas = 0; pas < distance; pas++) {
				posHead = getNewPositionHead(posHead.getKey(), posHead.getValue(), direction);
				posTail = getNewPositionTail(direction, posHead, posTail);
				map[posTail.getKey()][posTail.getValue()] = 1;
			}
			compterCaseVisitee(map);

		}

		int nbVisite = compterCaseVisitee(map);

		System.out.println("Nb case visitée > " + nbVisite);
	}

	private static int compterCaseVisitee(int[][] map) {
		int result = 0;
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				if (map[x][y] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
		return result;
	}

	private static Pair<Integer, Integer> getNewPositionTail(String direction, Pair<Integer, Integer> posHead,
			Pair<Integer, Integer> posTail) {

		if (haveToMove(posHead, posTail, direction)) {
			switch (direction) {
			case "L": {
				posTail = Pair.of(posHead.getKey(), posHead.getValue() + 1);
				break;
			}
			case "R": {
				posTail = Pair.of(posHead.getKey(), posHead.getValue() - 1);
				break;
			}
			case "U": {
				posTail = Pair.of(posHead.getKey() + 1, posHead.getValue());
				break;
			}
			case "D": {
				posTail = Pair.of(posHead.getKey() - 1, posHead.getValue());
				break;
			}
			}
		}

		return posTail;
	}

	private static boolean haveToMove(Pair<Integer, Integer> posHead, Pair<Integer, Integer> posTail,
			String direction) {

		switch (direction) {
		case "L": {
			if (posTail.getValue() - posHead.getValue() <= 1) {
				return false;
			}
			return true;
		}
		case "R": {
			if (posHead.getValue() - posTail.getValue() <= 1) {
				return false;
			}
			return true;
		}
		case "U": {
			if (posTail.getKey() - posHead.getKey() <= 1) {
				return false;
			}
			return true;
		}
		case "D": {
			if (posHead.getKey() - posTail.getKey() <= 1) {
				return false;
			}
			return true;
		}
		}
		return false;
	}

	private static Pair<Integer, Integer> getNewPositionHead(int i, int j, String direction) {
		Pair<Integer, Integer> newCoordHead = null;
		switch (direction) {
		case "L": {
			newCoordHead = Pair.of(i, j - 1);
			break;
		}
		case "R": {
			newCoordHead = Pair.of(i, j + 1);
			break;
		}
		case "U": {
			newCoordHead = Pair.of(i - 1, j);
			break;
		}
		case "D": {
			newCoordHead = Pair.of(i + 1, j);
			break;
		}

		}
		return newCoordHead;
	}

}
