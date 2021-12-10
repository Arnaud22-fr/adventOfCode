package advent2021.day10;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

	private static final String PARENTHESE_COMPLETE = "\\(\\)";
	private static final String CROCHET_COMPLETE = "\\[\\]";
	private static final String ACCOLADE_COMPLETE = "\\{\\}";
	private static final String CHEVRON_COMPLETE = "\\<\\>";
	private static final String PARENTHESE_OUV = "(";
	private static final String CROCHET_OUV = "[";
	private static final String ACCOLADE_OUV = "{";
	private static final String CHEVRON_OUV = "<";
	private static final String PARENTHESE_FER = ")";
	private static final String CROCHET_FER = "]";
	private static final String ACCOLADE_FER = "}";
	private static final String CHEVRON_FER = ">";

//	static List<String> datas = Datas.getDataTest();
	static List<String> datas = Datas.getData();

	public static void main(String[] args) {

		List<BigDecimal> scores = new ArrayList<BigDecimal>();

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

			if (!dataTest.contains(PARENTHESE_FER) && !dataTest.contains(CROCHET_FER)
					&& !dataTest.contains(ACCOLADE_FER) && !dataTest.contains(CHEVRON_FER)) {

				StringBuilder strb = new StringBuilder(dataTest);
				dataTest = strb.reverse().toString();
				dataTest = dataTest.replaceAll("\\" + PARENTHESE_OUV, PARENTHESE_FER);
				dataTest = dataTest.replaceAll("\\" + CROCHET_OUV, CROCHET_FER);
				dataTest = dataTest.replaceAll("\\" + ACCOLADE_OUV, ACCOLADE_FER);
				dataTest = dataTest.replaceAll("\\" + CHEVRON_OUV, CHEVRON_FER);

				BigDecimal score = new BigDecimal(0);

				for (int i = 0; i < dataTest.length(); i++) {
					score = score.multiply(new BigDecimal(5));
					score = score.add(new BigDecimal(CARACT_SCORE.getValueByCode(dataTest.substring(i, i + 1))));
				}
				scores.add(score);
//				System.out.println(score);

			}

		}

		Collections.sort(scores);

		System.out.println(scores.get(scores.size() / 2));
	}

	public enum CARACT_SCORE {
		PARENTHESE_FER(")", 1), CROCHET_FER("]", 2), ACCOLADE_FER("}", 3), CHEVRON_FER(">", 4);

		CARACT_SCORE(String code, int value) {
			this.code = code;
			this.value = value;
		}

		private String code;
		private int value;

		public static int getValueByCode(String code) {
			for (CARACT_SCORE gender : CARACT_SCORE.values()) {
				if (gender.code.equals(code)) {
					return gender.value;
				}
			}
			return 0;
		}
	}

}
