package advent.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

	private String cid;
	private String ecl;
	private String pid;
	private String eyr;
	private String hcl;
	private String byr;
	private String iyr;
	private String hgt;

	public Passport() {
		this.cid = "";
		this.ecl = "";
		this.pid = "";
		this.eyr = "";
		this.hcl = "";
		this.byr = "";
		this.iyr = "";
		this.hgt = "";
	}

	public void clear() {
		this.cid = "";
		this.ecl = "";
		this.pid = "";
		this.eyr = "";
		this.hcl = "";
		this.byr = "";
		this.iyr = "";
		this.hgt = "";
	}

	public boolean isValid() {
		if (!"".equals(ecl) && !"".equals(pid) && !"".equals(eyr) && !"".equals(hcl) && !"".equals(byr)
				&& !"".equals(iyr) && !"".equals(hgt)) {
			if (eclValid(ecl) && pidValid(pid) && eyrValid(eyr) && hclValid(hcl) && byrValid(byr) && iyrValid(iyr)
					&& hgtValid(hgt)) {
				return true;
			}
		}
		return false;
	}

	private boolean hgtValid(String hgt2) {

		String REGEX = "([0-9]{2,3})([ci][mn])";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(hgt2);
		if (matcher.find()) {
			int taille = Integer.parseInt(matcher.group(1));
			String unite = matcher.group(2);
			if (unite.equals("cm") && taille >= 150 && taille <= 193) {
				return true;
			}
			if (unite.equals("in") && taille >= 59 && taille <= 76) {
				return true;
			}
		}
		return false;
	}

	private boolean iyrValid(String iyr2) {
		if (iyr2.matches("[0-9]{4}")) {
			int iyrInt = Integer.parseInt(iyr2);
			if (iyrInt >= 2010 && iyrInt <= 2020) {
				return true;
			}
		}
		return false;
	}

	private boolean byrValid(String byr2) {

		if (byr2.matches("[0-9]{4}")) {
			int byrInt = Integer.parseInt(byr2);
			if (byrInt >= 1920 && byrInt <= 2002) {
				return true;
			}
		}

		return false;
	}

	private boolean hclValid(String hcl2) {

		if (hcl2.substring(0, 1).equals("#") && hcl2.substring(1).matches("[0-9a-f]{6}")) {
			return true;
		}
		return false;
	}

	private boolean eyrValid(String eyr2) {
		if (eyr2.matches("[0-9]{4}")) {
			int eyrInt = Integer.parseInt(eyr2);
			if (eyrInt >= 2020 && eyrInt <= 2030) {
				return true;
			}
		}
		return false;
	}

	private boolean pidValid(String pid2) {
		if (pid2.matches("[0-9]{9}")) {
			return true;
		}
		return false;
	}

	private boolean eclValid(String ecl2) {

		if (ecl2.matches("(amb)|(blu)|(brn)|(gry)|(grn)|(hzl)|(oth)")) {
			return true;
		}

		return false;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getEcl() {
		return ecl;
	}

	public void setEcl(String ecl) {
		this.ecl = ecl;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getEyr() {
		return eyr;
	}

	public void setEyr(String eyr) {
		this.eyr = eyr;
	}

	public String getHcl() {
		return hcl;
	}

	public void setHcl(String hcl) {
		this.hcl = hcl;
	}

	public String getByr() {
		return byr;
	}

	public void setByr(String byr) {
		this.byr = byr;
	}

	public String getIyr() {
		return iyr;
	}

	public void setIyr(String iyr) {
		this.iyr = iyr;
	}

	public String getHgt() {
		return hgt;
	}

	public void setHgt(String hgt) {
		this.hgt = hgt;
	}

}
