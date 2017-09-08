/**
 * The QuestionOne program implements UberPool feature that
 * determines which rider to pick on the way
 * 
 * @author Harsh Mathur
 */
import java.util.*;

public class QuestionOne {
	
	/**
	 * This function returns the shortest distance between the
	 * given two points 
	 * 
	 * @param point1 Accepts originating point Coordinates
	 * @param point2 Accepts destination point Coordinates
	 * @return int distance between given point1 and point2
	 */
	static int distance(int[] point1, int[] point2){
		return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
	}
	
	/**
	 * This function determines whether to pick other rider or not
	 * and which rider to pick
	 * 
	 * @param A departure point 
	 * @param B destination point
	 * @param C point​ ​at​ ​which​ ​two​ ​new​ ​requests​ ​came​ ​in
	 * @param X Coordinates​ ​of​ ​the​ ​first​ ​request
	 * @param Y Coordinates​ ​of​ ​the​ ​second​ ​request
	 * @return 1 if X is selected
	 *         2 if Y is selected
	 *        -1 if none are selected
	 */
	
	static int UberPool(int[] A, int[] B, int[] C, int[] X, int[] Y) {
		int val = -1;
		int distance_AC = distance(A,C); // calculate it separately because it is sure to happen
		int distance_CB = distance(B,C); 
		int distance_CX = distance(C,X);
		int distance_CY = distance(C,Y);
		int distance_XB = distance(X,B);
		int distance_YB = distance(Y,B);
		
		int distance_AB = distance_AC + distance_CB;
		int distance_AB_via_X = distance_AC + distance_CX + distance_XB;
		int distance_AB_via_Y = distance_AC + distance_CY + distance_YB;
		
		if((distance_AB_via_X <= distance_AB_via_Y) && (distance_AB_via_X <= (2*distance_AB))){
			val = 1;
		}else if((distance_AB_via_Y <= distance_AB_via_X) && (distance_AB_via_Y <= (2*distance_AB))){
			val = 2;
		}
		return val;
	}
	
	
	/**
	 * This is the main method which makes use of UberPool method.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[2]; 
		int[] B = new int[2];
		int[] C = new int[2];
		int[] X = new int[2];
		int[] Y = new int[2];
		int i;
		System.out.println("Enter co-ordinates of Departure");
		for(i = 0; i < 2; i++)
			A[i] = sc.nextInt();
		System.out.println("Enter co-ordinates of Destination");
		for(i = 0; i < 2; i++)
			B[i] = sc.nextInt();
		System.out.println("Enter co-ordinates of point where new request came in");
		for(i = 0; i < 2; i++)
			C[i] = sc.nextInt();
		System.out.println("Enter co-ordinates of first request");
		for(i = 0; i < 2; i++)
			X[i] = sc.nextInt();
		System.out.println("Enter co-ordinates of second request");
		for(i = 0; i < 2; i++)
			Y[i] = sc.nextInt();
		System.out.println("Returned Value : "+UberPool(A,B,C,X,Y));
		sc.close();
	}

	

}
