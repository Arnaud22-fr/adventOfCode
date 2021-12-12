package advent2021.day12;

import java.util.Arrays;
import java.util.List;

public class Datas {
	public static final List<String> datasTest = Arrays.asList("start-A", "start-b", "A-c", "A-b", "b-d", "A-end",
			"b-end");

	public static final List<String> datas = Arrays.asList("TR-start", "xx-JT", "xx-TR", "hc-dd", "ab-JT", "hc-end",
			"dd-JT", "ab-dd", "TR-ab", "vh-xx", "hc-JT", "TR-vh", "xx-start", "hc-ME", "vh-dd", "JT-bm", "end-ab",
			"dd-xx", "end-TR", "hc-TR", "start-vh");

	public static List<String> getDataTest() {
		return datasTest;
	}

	public static List<String> getData() {
		return datas;
	}

}
