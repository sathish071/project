package Project01;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Denomination {
	public static void main(String[] args) {
		// Object Creation Using Map
		Map<Integer, Integer> map = new <Integer, Integer>LinkedHashMap();
		map.put(2000, 5);
		map.put(1000, 5);
		map.put(500, 5);
		map.put(200, 5);
		map.put(100, 5);
		map.put(50, 5);
		map.put(20, 5);
		map.put(10, 5);
		map.put(5, 5);
		map.put(2, 5);
		map.put(1, 5);

		// Get input from user
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Amount ");
		int amt = sc1.nextInt();
		int overAllTotal = 0;
		int key = 0;
		int value = 0;
		sc1.close();
		// Do calculate the total initial amount
		for (Map.Entry<Integer, Integer> all : map.entrySet()) {
			key = all.getKey() * all.getValue();
			value = value + key;
		}

		// Allow only available amount and greater than zero
		if (amt < value && amt > 0) {
			int cashcount = 0;
			System.out.println("Calculation Of Given Amount :");
			System.out.println();
			System.out.println("CASH	       COUNT	       TOTAL");

			// Get Available cash and store cash
			for (int cash : map.keySet()) {
				// Here get value of the key and store it to count:
				int count = map.get(cash);				
				if (count > 0) {
					// get user given amount for all cash count to update and reduce the available count
					
						cashcount = amt / cash;
						amt = amt - cashcount * cash;
						map.put(cash, count - cashcount);// count
					
						if (cashcount != 0) {

							int cashTot = cash * cashcount;
							System.out.println(cash + "	x	" + cashcount + "	=	" + cashTot);
							overAllTotal = overAllTotal + cashTot;
						}
					}
			}
		} 
		
		else if (amt < 0) {
			System.out.println(" Please Enter Valid Amount...Accept Only Positive Value ");
		} else if (amt > value) {
			System.out.println("Available Amount is = " + value);
			System.out.println(" Given Amount Is "+"("+amt+")"+" More Than Available Amount");
		}

		System.out.println();
		System.out.println("Over All Total Amount = " + overAllTotal);
		System.out.println();
		System.out.println("Default Cash Count For All Available Amount is = 5");
		System.out.println("Now Available Cash Count Calculation :");
		System.out.println();
		System.out.println(map);

	}
}