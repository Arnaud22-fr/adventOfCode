package advent2021.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {

	private static final String PARENTHESE_COMPLETE = "\\(\\)";
	private static final String CROCHET_COMPLETE = "\\[\\]";
	private static final String ACCOLADE_COMPLETE = "\\{\\}";
	private static final String CHEVRON_COMPLETE = "\\<\\>";
	private static final String PARENTHESE_FER = ")";
	private static final String CROCHET_FER = "]";
	private static final String ACCOLADE_FER = "}";
	private static final String CHEVRON_FER = ">";
	private static final int PARENTHESE_VALUE = 3;
	private static final int CROCHET_VALUE = 57;
	private static final int ACCOLADE_VALUE = 1197;
	private static final int CHEVRON_VALUE = 25137;

//	static List<String> datas = Datas.getDataTest();
	static List<String> datas = Datas.getData();

	public static void main(String[] args) {

		int result = 0;

		for (String data : datas) {

			String dataTest = data;
			int oldStringLength = 0;

			while (oldStringLength != dataTest.length()
					&& (dataTest.contains(PARENTHESE_FER) || dataTest.contains(CROCHET_FER)
							|| dataTest.contains(ACCOLADE_FER) || dataTest.contains(CHEVRON_FER))) {

				oldStringLength = dataTest.length();
				dataTest = dataTest.replaceAll(PARENTHESE_COMPLETE, "");
				dataTest = dataTest.replaceAll(CROCHET_COMPLETE, "");
				dataTest = dataTest.replaceAll(ACCOLADE_COMPLETE, "");
				dataTest = dataTest.replaceAll(CHEVRON_COMPLETE, "");
			}
			if (dataTest.contains(PARENTHESE_FER) || dataTest.contains(CROCHET_FER) || dataTest.contains(ACCOLADE_FER)
					|| dataTest.contains(CHEVRON_FER)) {
				List<Integer> idx = new ArrayList<Integer>();
				if (dataTest.indexOf(PARENTHESE_FER) != -1)
					idx.add(dataTest.indexOf(PARENTHESE_FER));
				if (dataTest.indexOf(CROCHET_FER) != -1)
					idx.add(dataTest.indexOf(CROCHET_FER));
				if (dataTest.indexOf(ACCOLADE_FER) != -1)
					idx.add(dataTest.indexOf(ACCOLADE_FER));
				if (dataTest.indexOf(CHEVRON_FER) != -1)
					idx.add(dataTest.indexOf(CHEVRON_FER));
				Collections.sort(idx);
				switch (String.valueOf(dataTest.charAt(idx.get(0)))) {
				case PARENTHESE_FER:
					result += PARENTHESE_VALUE;
					break;
				case CROCHET_FER:
					result += CROCHET_VALUE;
					break;
				case ACCOLADE_FER:
					result += ACCOLADE_VALUE;
					break;
				case CHEVRON_FER:
					result += CHEVRON_VALUE;
					break;

				}
				System.out.println(result);

			}

		}

		System.out.println(result);
	}

}
