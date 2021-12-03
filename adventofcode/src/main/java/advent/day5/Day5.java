package advent.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {

	public static void main(String[] args) {

		List<Integer> ids = new ArrayList<Integer>();
		int idmax = 0;
		int id = 0;
		int rang = 0;
		int colonne = 0;

		int palier = 0;

		double rangBas = 0;
		double rangHaut = 127;
		double colonneGauche = 0;
		double colonneDroite = 7;

		for (String entree : DatasDay5.entrees) {

			String instruction1 = entree.substring(0, 1);
			String instruction2 = entree.substring(1, 2);
			String instruction3 = entree.substring(2, 3);
			String instruction4 = entree.substring(3, 4);
			String instruction5 = entree.substring(4, 5);
			String instruction6 = entree.substring(5, 6);
			String instruction7 = entree.substring(6, 7);
			String instruction8 = entree.substring(7, 8);
			String instruction9 = entree.substring(8, 9);
			String instruction10 = entree.substring(9, 10);

			if (instruction1.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction2.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction3.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction4.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction5.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction6.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction7.equals("F")) {
				rangHaut = Math.floor((rangHaut + rangBas) / 2);
			} else {
				rangBas = Math.ceil((rangHaut + rangBas) / 2);
			}
			System.out.println(rangBas + " " + rangHaut);

			if (instruction8.equals("R")) {
				colonneGauche = Math.ceil((colonneGauche + colonneDroite) / 2);
			} else {
				colonneDroite = Math.floor((colonneGauche + colonneDroite) / 2);
			}
			System.out.println(colonneGauche + " " + colonneDroite);

			if (instruction9.equals("R")) {
				colonneGauche = Math.ceil((colonneGauche + colonneDroite) / 2);
			} else {
				colonneDroite = Math.floor((colonneGauche + colonneDroite) / 2);
			}
			System.out.println(colonneGauche + " " + colonneDroite);

			if (instruction10.equals("R")) {
				colonneGauche = Math.ceil((colonneGauche + colonneDroite) / 2);
			} else {
				colonneDroite = Math.floor((colonneGauche + colonneDroite) / 2);
			}
			System.out.println(colonneGauche + " " + colonneDroite);

			rang = (int) rangBas;
			colonne = (int) colonneGauche;

			id = rang * 8 + colonne;
			ids.add(id);
			if (id > idmax) {
				idmax = id;
				id = 0;
			}
			rangHaut = 127;
			rangBas = 0;
			colonneGauche = 0;
			colonneDroite = 7;

		}

		System.out.println(idmax);
		Collections.sort(ids);

		int idPrecedent = 0;
		for (Integer idCourrant : ids) {
			if (idCourrant - idPrecedent == 2) {
				System.out.println(idPrecedent + (idCourrant - idPrecedent) / 2);
			} else {
				idPrecedent = idCourrant;
			}
		}

	}

}
