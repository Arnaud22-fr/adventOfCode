package advent2021.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Transfo {

	NV("NV", "V"), CF("CF", "O"), BB("BB", "F"), SB("SB", "H"), KF("KF", "O"), SP("SP", "H"), CS("CS", "V"),
	VF("VF", "F"), PC("PC", "H"), PH("PH", "H"), SF("SF", "F"), CP("CP", "B"), BC("BC", "H"), PB("PB", "V"),
	KO("KO", "B"), CV("CV", "S"), ON("ON", "B"), PV("PV", "F"), OO("OO", "B"), VV("VV", "B"), NO("NO", "B"),
	SH("SH", "N"), FC("FC", "C"), VO("VO", "B"), NN("NN", "C"), HH("HH", "S"), CK("CK", "C"), PF("PF", "N"),
	SN("SN", "K"), OK("OK", "F"), FH("FH", "S"), BP("BP", "K"), HO("HO", "K"), FB("FB", "P"), HC("HC", "N"),
	FP("FP", "P"), NC("NC", "H"), PK("PK", "O"), BV("BV", "P"), HK("HK", "S"), PP("PP", "N"), VC("VC", "K"),
	CH("CH", "C"), KS("KS", "V"), KB("KB", "V"), FN("FN", "P"), BS("BS", "O"), PS("PS", "N"), NS("NS", "B"),
	PN("PN", "N"), NP("NP", "H"), CB("CB", "S"), SV("SV", "O"), OC("OC", "H"), BO("BO", "C"), HN("HN", "N"),
	HP("HP", "N"), OF("OF", "H"), FS("FS", "S"), KV("KV", "P"), HV("HV", "S"), VS("VS", "P"), BH("BH", "N"),
	CC("CC", "V"), VN("VN", "H"), NF("NF", "B"), NK("NK", "N"), CN("CN", "F"), FV("FV", "P"), NH("NH", "S"),
	OV("OV", "H"), KN("KN", "F"), SO("SO", "H"), OP("OP", "N"), KC("KC", "P"), HB("HB", "B"), BN("BN", "V"),
	VP("VP", "N"), HS("HS", "S"), VK("VK", "C"), VH("VH", "H"), OS("OS", "C"), FO("FO", "B"), NB("NB", "P"),
	KP("KP", "V"), SS("SS", "O"), BK("BK", "F"), SK("SK", "N"), HF("HF", "O"), PO("PO", "F"), OH("OH", "B"),
	KK("KK", "O"), FK("FK", "S"), VB("VB", "V"), OB("OB", "C"), KH("KH", "H"), SC("SC", "F"), FF("FF", "H"),
	CO("CO", "V"), BF("BF", "H");

	private String code;
	private String text;

	private Transfo(String code, String text) {
		this.code = code;
		this.text = text;
	}

	// Static method return Gender by code.
	public static Transfo getTransfoByCode(String code) {
		for (Transfo transfo : Transfo.values()) {
			if (transfo.code.equals(code)) {
				return transfo;
			}
		}
		return null;
	}

	public static List<String> getAllCode() {
		List<String> codes = new ArrayList<String>();
		for (Transfo transfo : Transfo.values()) {
			codes.add(transfo.getText());
		}
		return codes.stream().distinct().collect(Collectors.toList());
	}

	public static Map<String, Character> getMap() {
		Map<String, Character> maps = new HashMap<>();
		for (Transfo transfo : Transfo.values()) {
			maps.put(transfo.code, transfo.text.charAt(0));
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
