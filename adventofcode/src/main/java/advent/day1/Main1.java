package advent.day1;

public class Main1 {

	public static void main(String[] args) {
		
		Integer result = 0;
		
		while(result != 2020) {
			
			for(Integer entree1 : Datas.getEntrees()) {
				for(Integer entree2 : Datas.getEntrees()) {
					for(Integer entree3 : Datas.getEntrees()) {
					
					if(entree1+entree2+entree3 == 2020) {
						result = entree1 * entree2 * entree3;
						System.out.println(result);
						break;
					}
				}
					if (result != 0) break;
					
				}	
				if (result != 0) break;
				
				
			}
			
		}

	}

}
