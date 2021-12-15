package advent2021.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum TransfoTest {

	CH("CH", "B"), HH("HH", "N"), CB("CB", "H"), NH("NH", "C"), HB("HB", "C"), HC("HC", "B"), HN("HN", "C"),
	NN("NN", "C"), BH("BH", "H"), NC("NC", "B"), NB("NB", "B"), BN("BN", "B"), BB("BB", "N"), BC("BC", "B"),
	CC("CC", "N"), CN("CN", "C");

	private String code;
	private String text;

	private TransfoTest(String code, String text) {
		this.code = code;
		this.text = text;
	}

	// Static method return Gender by code.
	public static TransfoTest getTransfoTestByCode(String code) {
		for (TransfoTest transfoTest : TransfoTest.values()) {
			if (transfoTest.code.equals(code)) {
				return transfoTest;
			}
		}
		return null;
	}

	public static List<String> getAllCode() {
		List<String> codes = new ArrayList<String>();
		for (TransfoTest transfoTest : TransfoTest.values()) {
			codes.add(transfoTest.getText());
		}
		return codes.stream().distinct().collect(Collectors.toList());
	}

	public static Map<String, Character> getMap() {
		Map<String, Character> maps = new HashMap<>();
		for (TransfoTest transfoTest : TransfoTest.values()) {
			maps.put(transfoTest.code, transfoTest.text.charAt(0));
		}
		return maps;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
