/*Author: Dilay Sapmaz
 * ID= 041701032
 * Date: 09.01.2019
 * Array lists, linked lists, hash maps and binary search trees can be used for searching. In this code, I'm going to analyze the search performance of these data structures. 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class dilay_sapmaz {

	public static void shuffleArray(int[] a) {
		int n = a.length;
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(a, i, change);
		}
	}

	private static void swap(int[] a, int i, int change) {
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M=1000;
		System.out.println("Sequence Size; Array List Search Time; Hash Map Search Time; Linked List Search Time; BST Search Time");
		while(M<100000) {
			int[] array= new int[M];
			for(int i=1;i<array.length;i++) {
				array[i]=i+1;
			}
			shuffleArray(array); 
			//for(int j=0;j<array.length;j++) {
			//System.out.println(array[j]);
			//}
			
			LinkedList<Integer> object = new LinkedList<Integer>();
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		    ArrayList<Integer> arrayL = new ArrayList<>();
			BST tree = new BST();
			for(int i=0;i<array.length;i++) {
				object.add(array[i]);
				hmap.put(array[i], array[i]);
				tree.insert(array[i]);
				arrayL.add(array[i]);

			}
			double start = System.nanoTime(); // code to measure timing
			for(int i=0;i<array.length;i++) {
				object.contains(i);
			}
			double finish = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; //convert nanoseconds to milliseconds

			double start1 = System.nanoTime(); // code to measure timing
			for(int i=0;i<array.length;i++) {
				arrayL.contains(i);
			}
			double finish1 = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds1 = (finish1 - start1) / 1000000.0; //convert nanoseconds to milliseconds
			
			double start2 = System.nanoTime(); // code to measure timing
			for(int i=0;i<array.length;i++) {
				hmap.containsKey(i);	
			}
			double finish2 = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds2 = (finish2 - start2) / 1000000.0; //convert nanoseconds to milliseconds

			double start3 = System.nanoTime(); // code to measure timing
			for(int i=0;i<array.length;i++) {
				tree.search(i);
			}
			double finish3 = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds3 = (finish3 - start3) / 1000000.0; //convert nanoseconds to milliseconds

			
			System.out.println(M + ";" +elapsedTimeMilliSeconds1 + ";" + elapsedTimeMilliSeconds2+ ";" + elapsedTimeMilliSeconds + ";"+ elapsedTimeMilliSeconds3 );
			
			M+=1000;
			
		}
		
		
		
		
	}

	

}
