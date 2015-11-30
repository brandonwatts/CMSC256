package Assignment4;
/**
 * This program tests MySkipList.java
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */
public class SkipListTest 
{
	public static void main(String [] args)
	{
		/**
		 * Create a new SkipList
		 */
		MySkipList list = new MySkipList();

		/**
		 * Add 50 random numbers
		 */
		for(int i=0;i<50;i++)
		{
			list.skipInsert((int)(Math.random()*50+1));
		}

		/**
		 * Attempt to remove 3
		 */
		System.out.println("3 was removed: " + list.skipRemove(3));

		/**
		 * Attempt to remove 43
		 */
		System.out.println("43 was removed: " + list.skipRemove(43));


	}


}


