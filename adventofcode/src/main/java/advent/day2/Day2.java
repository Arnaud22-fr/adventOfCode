package advent.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

	public static void main(String[] args) {
		
		int results = 0;
		
		for (String entree : DatasDay2.entrees) {

			String[] groupes = entree.split(" ");
			String[] nbs = groupes[0].split("-");
			int min = Integer.parseInt(nbs[0]);
			int max = Integer.parseInt(nbs[1]);
			
			String letter = groupes[1].substring(0, 1);
			
			String pw = groupes[2].trim();  
			
			int count = 0;
			
			for (int index = 0 ; index < pw.length(); index++) {
				if(pw.substring(index, index+1).equals(letter)) {
					count++;
				}
			}
			
			if (count >= min && count <= max) {
				results++;
			}
			
			
		}
		
		System.out.println(results);
		
		

	}

}
