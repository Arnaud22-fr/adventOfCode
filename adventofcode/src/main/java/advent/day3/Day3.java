package advent.day3;

public class Day3 {

	public static void main(String[] args) {

		int position = 0;
		int numeroLigne = 0;
		int resultat = 0;

		for (String entree : DatasDay3.entrees) {

			// On ne prend pas en compte la première ligne
			if (numeroLigne == 0 || numeroLigne % 2 == 1) {
				numeroLigne++;
			} else {
				// on incrémente se déplace
				position += 1;
				System.out.println(position);

				// On agrandi l'entrée si besoin
				while (position >= entree.length()) {
					entree += entree;
					System.out.println(entree);
				}
				if (entree.substring(position, position + 1).equals("#")) {
					resultat += 1;
				}
				numeroLigne++;

			}

		}

		System.out.println(resultat);
		// 90 278 88 98 45

	}

}

//.....#............#....#####.##   0
//.#.X....#......#....##.........	3
//......X.#.#.....###.#.#........	6
//......#..O#.....#####....#..##.	9
//...#........O...##...###.##....	12
//#.....#...#....X......##....##.	15
//#...#.#....#..#..#X.##...#.....	18
//.......#..........#..X..#.#....	21
//.#.....#.#.......#..#...X....#.	24
//#..#.##.#..................X##.	27
//...#.#.##...##.###.....#..#...X	30
//..#.#...#............#.......#...X.#...#............#.......#.	0
//#.O#.#..#.#....#...#.#.....#..##..#.X..#.#....#...#.#.....#..#	2
//#....O.##....#..#.#.#........#.#......#X....#..#.#.#........#.	5