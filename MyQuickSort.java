package Assignment4;

import java.util.Random;

/**
 * This program implements the quicksort algorithim
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */

public class MyQuickSort
{

	/**
	 * Passes an array to quickSort() assuming the whole array needs to be sorted
	 * 
	 * @param array    array to be sorted
	 * @return         sorted array
	 */
	static int [ ] quickSort(int[] array)
	{
		fisherYates(array); // we shuffle the array to stop worst case complexity
		quickSort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Simple quickSort Algorithim
	 * 
	 * @param array   unsorted array
	 * @param left    left half
	 * @param right   right half
	 */
	public static void quickSort(int array[], int left, int right)
	{
		int pivot, temp;
		int a = left;
		int b = right;
		pivot = array [(left + right) / 2];

		do
		{
			while (array [a] > pivot && (a < right))   
			{
				a++;						//move the partition to the right
			}

			while ((pivot > array [b]) && (b > left))
			{
				b--;						//move the partition to the left
			}

			if (a <= b)   //simple bubble sort
			{
				temp = array [a];
				array [a] = array [b];
				array [b] = temp;
				a++;
				b--;
			}
		}
		while (a <= b); //stop when sorted

		if (left < right)    //combine and sort again
		{
			quickSort (array, left, b);
		}

		if (a < right)   //combine and sort again
		{
			quickSort (array, a, right);
		}
	}
	
	/**
	 * Simple Fisher-Yates shuffle to randomize array to stop worse case        ***  Source: http://www.programming-algorithms.net/article/43676/Fisher-Yates-shuffle ***
	 * 
	 * @param a   array
	 */
	/**
	 * An improved version (Durstenfeld) of the Fisher-Yates algorithm with O(n) time complexity
	 * Permutes the given array
	 * @param array array to be shuffled
	 */
	public static void fisherYates(int[] array) {
	    Random r = new Random();
	    for (int i = array.length - 1; i > 0; i--) {
	        int index = r.nextInt(i);
	        //swap
	        int tmp = array[index];
	        array[index] = array[i];
	        array[i] = tmp;
	    }
	} 
}

