package advent.day7;

import java.util.List;

public class Regle {

	public String sac;

	public List<String> sacs;

	public int shinyGold;

	public boolean isShiny;

	public boolean isShiny() {
		return isShiny;
	}

	public void setShiny(boolean isShiny) {
		this.isShiny = isShiny;
	}

	public int getShinyGold() {
		return shinyGold;
	}

	public void setShinyGold(int shinyGold) {
		this.shinyGold = shinyGold;
	}

	public String getSac() {
		return sac;
	}

	public void setSac(String sac) {
		this.sac = sac;
	}

	public List<String> getSacs() {
		return sacs;
	}

	public void setSacs(List<String> sacs) {
		this.sacs = sacs;
	}

	@Override
	public String toString() {
		return sac + " contain " + sacs + "]";
	}

}
