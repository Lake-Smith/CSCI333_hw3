/**
 * Lake Smith(lsmith17)
 * 09/16/2021
 * CSCI333_fall2021
 * Homework3_Quicksort
 * 
 * Description:
 * In this file I created several methods, the main of which being quicksort,
 * random quicksort, partiton and main
 * Main creates new arrays then sorts them using both quick sort and random quick sort
 * then prints the new sorted array
 * Quick sort sorts starting from the far right index of the array
 * Partition finds a partitions and returns it
 * Random quicksort does the same thing as quick sort only it uses a random 
 * index then swaps that out with the far right index
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quicksort {
	//int[] A = {18, 7, 16, 10, 19, 12, 15, 9, 3, 11};
	
	//
	/**
	 * quicksort
	 * sorts the the data naive starting at the right most item in the array every time, additionally this is a inclusive upper bound
	 * @param A is the array passed in
	 * @param p is the part of the array with which this instance of quick sort starts
	 * @param r is the part of the array with which this instance of quick sort ends
	 */
	private void quicksort(int[] A,int p, int r) {
		//checks if the array exist because if p was not less than r it would be impossible
		if(p < r) {
			// partitions it
			int q  = partition(A, p, r);
			// recurses on 2 new partitions
			quicksort(A, p, q-1);
			quicksort(A, q+1, r);
		}
		
	}
	
	/**
	 * partition
	 * goes through the section of the array from p to r and organizes it in such a way that it find a middle index to return
	 * @param A The array passed it
	 * @param p the beginning of the section of the array this function is working with
	 * @param r the end of the section of the array this function is working with
	 * @return the middle index
	 */
	private int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i = i + 1;
				A = swap(A, i,j);
			}
		}
		A = swap(A, i+1,r);
		return i+1;
	}
	
	/**
	 * swap
	 * swaps 2 items in the array passed into it then returns the new altered array
	 * @param A is the array thats passed in
	 * @param p is the first item being swapped
	 * @param r is the second item being swapped
	 * @return the new altered array
	 */
	private int[] swap(int[] A, int p, int r) {
		int temp = A[p];
		A[p] = A[r];
		A[r] = temp;
		return A;
	}
	
	
	/**
	 * randomInt
	 * Returns a random number between p and r
	 * @param p is the minimum number
	 * @param r is the maximum number
	 * @return the random number
	 */
	private int randomInt(int p, int r) {
		Random rand = new Random();
		int num = (rand.nextInt(r-1) + p) - 1;
		return num;
	}
	
	/**
	 * randomizedQuicksort
	 * same as quick sort where it calls partition and then recurses on the 2 sections
	 * but here it swaps a random item in the array with the item at the end of the list
	 * @param A The passed in array
	 * @param p Where the instance of the array this instance of randomQuicksort is using is starting
	 * @param r Where the instance of the array this instance of randomQuicksort is using is ending
	 */
	private void randomizedQuicksort(int[] A, int p, int r) {
		if(p<r) {
			//picks random item then swaps it
			int z = randomInt(p,r);
			A = swap(A, z,r);
			//then calls parition
			int q = partition(A, p,r);
			//recurses on 2 new sections
			quicksort(A, p, q-1);
			quicksort(A, q+1, r);
		}
	}
	
	/**
	 * uses input from used to create 10 total arrays of 10 inputed values each
	 * first 5 arrays are solved using quick sort
	 * the second 5 arrays are solves using random quick sort
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner Obj = new Scanner(System.in);
		//quick sort
		//loop that allows the user to run quick sort on 5 arrays
		for(int i = 0; i < 1; i++) {
			int[] A = new int[10];
			System.out.println("enter 10 number for the array");
			// a loop that allows the user to input there 10 items into the array
			for(int j = 0; j < 10; j++) {
				System.out.print("enter a new number:  ");
				int num = Obj.nextInt();
				A[j] = num;
			}			
			Quicksort QS = new Quicksort();
			System.out.println("Quick Sort:");
			System.out.println(Arrays.toString(A));
			QS.quicksort(A, 0, A.length-1);
			System.out.println(Arrays.toString(A));
		}
		
		System.out.println();
		//random quick sort
		//allows the user to run 5 instances of random quick sort
		for(int i = 0; i < 1; i++) {
			int[] A = new int[10];
			System.out.println("enter 10 number for the array");
			//allows the user to input the 10 values into the array
			for(int j = 0; j < 10; j++) {
				System.out.println("enter a new number");
				int num = Obj.nextInt();
				A[j] = num;
			}			
			Quicksort RQS = new Quicksort();
			System.out.println("Randomized quick sort:");
			System.out.println(Arrays.toString(A));
			RQS.randomizedQuicksort(A, 0, A.length-1);
			System.out.println(Arrays.toString(A));
		}

	}
	
	
	
	
	
}
