package advent2022.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class Monkey {

	int number;
	List<String> items;
	long divide;
	int vrai;
	int faux;
	BigInteger currentWorry;
	long nbPass = 0;

	public Monkey(String description) {
		super();
		this.number = Integer.valueOf(description.split(";")[0]);
		this.items = Arrays.asList(description.split(";")[1].split(","));
		this.divide = Integer.valueOf(description.split(";")[2]);
		this.vrai = Integer.valueOf(description.split(";")[3]);
		this.faux = Integer.valueOf(description.split(";")[4]);
	}

	public Pair<Integer, BigInteger> getDestinationAndValue(long itemValue, boolean recalculWorry) {

		List<String> newItem = new ArrayList<>();
		boolean premier = true;
		for (String item : this.items) {
			if (!premier) {
				newItem.add(item);
			} else {
				premier = false;
			}
		}
		this.items = newItem;

		switch (this.number) {
		case 0: {
			this.currentWorry = BigInteger.valueOf(itemValue).multiply(BigInteger.valueOf(17L));
			break;
		}
		case 1: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(2L));
			break;
		}
		case 2: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(1L));
			break;
		}
		case 3: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(7L));
			break;
		}
		case 4: {
			this.currentWorry = BigInteger.valueOf(itemValue).multiply(BigInteger.valueOf(itemValue));
			break;
		}
		case 5: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(8L));
			break;
		}
		case 6: {
			this.currentWorry = BigInteger.valueOf(itemValue).multiply(BigInteger.valueOf(2L));
			break;
		}
		case 7: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(6L));
			break;
		}

		}
		this.nbPass += 1;

		if (recalculWorry) {
			this.currentWorry = this.currentWorry.divide(BigInteger.valueOf(3));
		} else {
			this.currentWorry = this.currentWorry.mod(BigInteger.valueOf(3 * 13 * 2 * 11 * 19 * 17 * 5 * 7));
		}

		if (this.currentWorry.mod(BigInteger.valueOf(this.divide)) == BigInteger.ZERO) {
			return Pair.of(this.vrai, this.currentWorry);
		} else {
			return Pair.of(this.faux, this.currentWorry);
		}
	}

	public Pair<Integer, BigInteger> getDestinationAndValueTest(long itemValue, boolean recalculWorry) {

		List<String> newItem = new ArrayList<>();
		boolean premier = true;
		for (String item : this.items) {
			if (!premier) {
				newItem.add(item);
			} else {
				premier = false;
			}
		}
		this.items = newItem;

		switch (this.number) {
		case 0: {
			this.currentWorry = BigInteger.valueOf(itemValue).multiply(BigInteger.valueOf(19L));
			break;
		}
		case 1: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(6L));
			;
			break;
		}
		case 2: {
			this.currentWorry = BigInteger.valueOf(itemValue).multiply(BigInteger.valueOf(itemValue));
			break;
		}
		case 3: {
			this.currentWorry = BigInteger.valueOf(itemValue).add(BigInteger.valueOf(3L));
			;
			break;
		}

		}
		this.nbPass += 1;

		if (recalculWorry) {
			this.currentWorry = this.currentWorry.divide(BigInteger.valueOf(3));
		} else {
			this.currentWorry = this.currentWorry.mod(BigInteger.valueOf(23 * 19 * 13 * 17));
		}

		if (this.currentWorry.mod(BigInteger.valueOf(this.divide)) == BigInteger.ZERO) {
			return Pair.of(this.vrai, this.currentWorry);
		} else {
			return Pair.of(this.faux, this.currentWorry);
		}

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public long getDivide() {
		return divide;
	}

	public void setDivide(long divide) {
		this.divide = divide;
	}

	public int getVrai() {
		return vrai;
	}

	public void setVrai(int vrai) {
		this.vrai = vrai;
	}

	public int getFaux() {
		return faux;
	}

	public void setFaux(int faux) {
		this.faux = faux;
	}

	public BigInteger getCurrentWorry() {
		return currentWorry;
	}

	public void setCurrentWorry(BigInteger currentWorry) {
		this.currentWorry = currentWorry;
	}

	public long getNbPass() {
		return nbPass;
	}

	public void setNbPass(long nbPass) {
		this.nbPass = nbPass;
	}

}
