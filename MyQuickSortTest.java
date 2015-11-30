package Assignment4;
/**
 * This program tests MyQuickSort.java
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */

public class MyQuickSortTest
{
	/**
	 * An empty array of size 100
	 */
	static int[] randomArray = new int[100];

	public static void main (String args[])
	{
		/**
		 * Generate a random integer array numbers 1-100
		 */
		randomArray=generaterandomArray(randomArray);

		/**
		 * Print unsorted array
		 */
		System.out.println("Original array: ");
		display(randomArray);

		/**
		 * Sort the array
		 */
		MyQuickSort.quickSort(randomArray);
		System.out.println();

		/**
		 * Print sorted Array
		 */
		System.out.println("\nSorted array: ");
		display(randomArray);
	}

	/**
	 * Displays the array 
	 */
	public static void display(int[] array)
	{
		for (int value : array)
		{
			System.out.print(value + " ");
		}
	}

	/**
	 * Returns an array with a random integer from 0-100 in each space
	 * 
	 * @param a    empty array
	 * @return     randomized array
	 */
	public static int[] generaterandomArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			a[i] = (int) (Math.random()*100+1);
		}
		return a;
	}

}