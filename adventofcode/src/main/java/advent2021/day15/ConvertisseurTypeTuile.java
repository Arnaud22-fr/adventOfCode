package advent2021.day15;

class ConvertisseurTypeTuile {
	public static TypeTuile charToType(char c) {
		switch (c) {
		case '1':
			return TypeTuile.un;
		case '2':
			return TypeTuile.deux;
		case '3':
			return TypeTuile.trois;
		case '4':
			return TypeTuile.quatre;
		case '5':
			return TypeTuile.cinq;
		case '6':
			return TypeTuile.six;
		case '7':
			return TypeTuile.sept;
		case '8':
			return TypeTuile.huit;
		case '9':
			return TypeTuile.neuf;
		}
		return null;
	}
}
