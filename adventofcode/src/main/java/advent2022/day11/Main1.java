package advent2022.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

	public static void main(String[] args) {

		List<Monkey> monkeys = new ArrayList<>();

		for (String data : Datas.monkeysTest) {
			monkeys.add(new Monkey(data));
		}

		for (int i = 0; i < 20; i++) {
			System.out.println("=====================");
			for (Monkey monkey : monkeys) {
				System.out.println("monkey " + monkey.getNumber() + " => " + monkey.getNbPass());
				for (String item : monkey.getItems()) {
					var result = monkey.getDestinationAndValueTest(Integer.valueOf(item), true);
					List<String> oldItems = new ArrayList<>();
					oldItems.addAll(monkeys.get(result.getKey()).getItems());
					oldItems.add(String.valueOf(result.getValue()));
					monkeys.get(result.getKey()).setItems(oldItems);
				}
			}
		}

		List<Monkey> sortedMonkeys = monkeys.stream().sorted(Comparator.comparingLong(Monkey::getNbPass))
				.collect(Collectors.toList());

//		System.out.println(sortedMonkeys.get(6).getNbPass() * sortedMonkeys.get(7).getNbPass());
		System.out.println(sortedMonkeys.get(1).getNbPass() * sortedMonkeys.get(2).getNbPass());
	}

}
