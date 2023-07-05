package homewr;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		int start;
//		int end;
//		int sum = 0;
//
//		System.out.println("Input start: ");
//		start = sc.nextInt();
//
//		System.out.println("Input end: ");
//		end = sc.nextInt();
//
//		if(end>start) {
//			for (int i = start; i <= end; i++) {
//				sum += i;
//			}
//		}else {
//			for (int i = end; i <= start; i++) {
//				sum += i;
//			}
//		}
//	
//		System.out.println(sum);
		
		
		Scanner sc = new Scanner(System.in);
	    int h;
	    System.out.println("Input h");
	    h = sc.nextInt();

	    for (int j = 1; j <= h; j++) {
	        for (int i = 1; i <= h; i++) {
	          if (i <= h - j) {   
	            System.out.print(" ");
	          } else {
	            System.out.print("*");
	          }
	        }
	        System.out.println();
	      }

	}
	
	// j = 1, i=1 h=4 1 <= (4-1), 2 <= (4-1), 3 <= (4-1), 4<= (4-1) 

	// j = 2, i=1 h=4 1 <= (4-2), 2 <= (4-2), 3 <= (4-2), 4<= (4-2)
	// j = 3, i=1 h=4 1 <= (4-3), 2 <= (4-3), 3 <= (4-3), 4<= (4-3)
	// j = 4, i=1 h=4 1 <= (4-4), 2 <= (4-4), 3 <= (4-4), 4<= (4-4)

}
