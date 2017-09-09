import java.util.*;
public class QuestionFour {
	
	/**
	 * This function returns the Greatest common divisor of two numbers
	 * @param a Number need to be compared
	 * @param b Number need to be compared
	 * @return Greatest common divisor of a and b
	 */
	static long gcd(long a, long b) {
		if (a == 0)
            return b;
		else if (b == 0)
			return a;
		else 
			return gcd(b%a, a);
	}
	
	
	/**
	 * This function first makes all sub-sets including empty subset from passed array
	 * then for each subset GCD is calculated
	 *  
	 * @param arr Given array (super set)
	 * @param n Length of array
	 * @return product of GCD of each sub-set
	 */
	static long getGCDProduct(int[] arr, int n) {
		int modulo = (int) (1e9 + 7);
		long ans = 1;
		int possibleComb = (int) Math.pow(2, n);
		List<List<Integer>> allSets = new ArrayList<List<Integer>>();
		List<Integer> current_row ;
		long gcd_of_row;
		
		// performing bit wise shift to get all combinations of elements in array
		for (int i = 0; i < (1<<n); i++){
			current_row = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
	               if ((i & (1 << j)) > 0)
	            	   current_row.add(arr[j]);  
			 allSets.add(current_row);
		 }
		
		for(int i = 1; i < possibleComb; i++){           //Start i from 1 to ignore empty-set
			current_row = allSets.get(i);                //select one row (sub set) at a time
			gcd_of_row = current_row.get(0);             //choose 1st value of each sub-set as initial GCD
			for (int j=1; j<current_row.size(); j++)
					gcd_of_row = gcd(current_row.get(j), gcd_of_row);
		
			ans *= gcd_of_row;
		}
		return ans%modulo;
	}
	
	
	/**
	 * This main function makes the use of method getGCDProduct to get the product of
	 * GCD's of each sub-set for the given array of Integers
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j = 0; j < t; j++){
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(getGCDProduct(arr, N));
		}
		sc.close();
	}
}
