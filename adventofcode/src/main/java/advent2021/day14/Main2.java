package advent2021.day14;

public class Main2 {
//	static String datas = Datas.getDataTest();
	static String datas = Datas.getData();
	static boolean isDataTest = true;

	public static void main(String[] args) {

		Thread thread1 = new Thread(new PolyTraitement(datas.substring(0, 2)));
		Thread thread2 = new Thread(new PolyTraitement(datas.substring(1, 3)));
		Thread thread3 = new Thread(new PolyTraitement(datas.substring(2, 4)));
		Thread thread4 = new Thread(new PolyTraitement(datas.substring(3, 5)));
		Thread thread5 = new Thread(new PolyTraitement(datas.substring(4, 6)));
		Thread thread6 = new Thread(new PolyTraitement(datas.substring(5, 7)));
		Thread thread7 = new Thread(new PolyTraitement(datas.substring(6, 8)));
		Thread thread8 = new Thread(new PolyTraitement(datas.substring(7, 9)));
		Thread thread9 = new Thread(new PolyTraitement(datas.substring(8, 10)));
		Thread thread10 = new Thread(new PolyTraitement(datas.substring(9, 11)));

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();

		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}