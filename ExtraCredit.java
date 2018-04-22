package notes;

public class ExtraCredit {
	public static void main(String[] args) {
		
		//larger list
//		int sack[] = new int[50];
		//smaller list
		int sack[] = new int[15];
		//giving values to the sack's capacity
		for (int i = 0; i < sack.length; i++) {
			sack[i] = i;
		}
		//item: item, weight, value
		//item[i][0]= name/num
		//item[i][1] = weight
		//item[i][2] = value
		//larger list
		//larger list
//		int item[][] = new int[6][3];
		//smaller list
		int item[][] = new int[3][3];
		//assigning names:
		for (int i = 0; i < item.length; i++) {
			item[i][0] = i + 1;
		}
		
		//smaller list
		//smaller weights
		item[0][1] = 5;
		item[1][1] = 10;
		item[2][1] = 7;
		//assigning values
		item[0][2] = 37;
		item[1][2] = 15;
		item[2][2] = 25;

		//larger list
//		//assigning weights:
//		item[0][1] = 15;
//		item[1][1] = 25;
//		item[2][1] = 45;
//		item[3][1] = 30;
//		item[4][1] = 23;
//		item[5][1] = 37;
//		//assigning values:
//		item[0][2] = 100;
//		item[1][2] = 350;
//		item[2][2] = 225;
//		item[3][2] = 67;
//		item[4][2] = 275;
//		item[5][2] = 168;
		
		//This prints out the items table as I would expect
		System.out.println("Item\tWeight\tValue");
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[0].length; j++) {
				System.out.print(Integer.toString(item[i][j]) + "\t");
			}
			System.out.println("");
		}
		
		//the ending table
		int max[][] = new int[item.length+1][sack.length+1];
		//instantiating the 0th spots on the array to 0
		for (int i = 0; i < max.length; i++) {
			max[i][0] = 0;
		}
		//instantiating the 0th spots on the array to 0
		for (int i = 0; i < max[0].length; i++) {
			max[0][i] = 0;
		}

		//adding things to the max table
		for (int i = 1; i < max.length; i++) {
			for (int j = 1; j < max[0].length; j++) {
				max[i][j] = max[i - 1][j];
				int weightLeft = j;
				if (item[i - 1][1] <= weightLeft) {
					weightLeft -= item[i - 1][1];
					if ((item[i - 1][2] + max[i - 1][weightLeft]) > max[i - 1][j]) {
						max[i][j] = (item[i - 1][2] + max[i - 1][weightLeft]);
					}
				}
			}
		}

		//Printing out the Knapsack after the algorithm has run
		//formating
		System.out.println("");
		System.out.println("");
		System.out.println("The full knapsack: ");
		for (int i = 0; i <= sack.length; i++) {
			System.out.print(Integer.toString(i) + "\t");
		}
		System.out.println("");
		for (int i = 0; i < max.length; i++) {
			for (int j = 0; j < max[0].length; j++) {
				System.out.print(Integer.toString(max[i][j]) + "\t");
			}
			System.out.println("");
		}
	}
}
