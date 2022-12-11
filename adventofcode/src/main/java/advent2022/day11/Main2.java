package advent2022.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

	public static void main(String[] args) {

		List<Monkey> monkeys = new ArrayList<>();

		for (String data : Datas.monkeys) {
			monkeys.add(new Monkey(data));
		}

		for (int i = 0; i < 10000; i++) {
			if (i == 1 || i == 20) {
				System.out.println("========= " + i + " =========");
			}

			for (Monkey monkey : monkeys) {
				if (i == 1 || i == 20) {
					System.out.println("monkey " + monkey.getNumber() + " => " + monkey.getNbPass());
				}

				for (String item : monkey.getItems()) {
					var result = monkey.getDestinationAndValue(Integer.valueOf(item), false);
					List<String> oldItems = new ArrayList<>();
					oldItems.addAll(monkeys.get(result.getKey()).getItems());
					oldItems.add(String.valueOf(result.getValue()));
					monkeys.get(result.getKey()).setItems(oldItems);
				}
			}
		}

		List<Monkey> sortedMonkeys = monkeys.stream().sorted(Comparator.comparingLong(Monkey::getNbPass))
				.collect(Collectors.toList());

		System.out.println(sortedMonkeys.get(6).getNbPass() * sortedMonkeys.get(7).getNbPass());
	}

}
