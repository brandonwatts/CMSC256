package Assignment4;
/**
 * This program implements the HashMap ADT for Strings. This differs from the HashTable ADT because mine can accept null values. 
 * Collisions are handled with 
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */

import java.util.LinkedList;
import java.util.Iterator;

public class MyStringHash {

	/**
	 * Array of Linked Lists for storage of Strings
	 */
	static LinkedList<String>[] stringArray;

	/**
	 * Constructs the HashMap of a particular size
	 * 
	 * @param max      size of HashMap
	 */
	public MyStringHash(int max)
	{
		stringArray  = (LinkedList<String>[])  new LinkedList<?>[max];	//This looks weird but java doesn't cast automatically for some reason
	}

	/**
	 * Simple hashCode algorithm designed by Joshua Bloch in his book "Effective Java"
	 * 
	 * @param s    String to be hased
	 * @return     Resulting hashCode
	 */
	public int hashCode(String s) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	/**
	 * Adds a string to the HashMap. Accepts null and does not repeat duplicates.
	 * 
	 * @param input_string    String to be added
	 */
	public void add(String input_string)
	{
		int hashcode = hashCode(input_string);                //get the hashCode
		int position = Math.abs(hashcode % (stringArray.length));     //find out where it goes
		if(stringArray[position]==null)                       //if nothing is there
		{
			stringArray[position] = new LinkedList<String>();  //make a LinkedList there
			stringArray[position].add(input_string);           //store the input value in it
		}
		else                                                   //something is there
		{
			if (!this.contains(input_string))                   //if its not already in there
			{
				stringArray[position].add(input_string);        //put it in there
			}
		}

	}

	/**
	 * Checks whether a given string is contained within the HashMap
	 * 
	 * @param input_string        String to be checked
	 * @return                    true if it is, false if its not
	 */
	boolean contains(String input_string)
	{
		int hashcode = hashCode(input_string);
		int position = Math.abs(hashcode % (stringArray.length));
		if(stringArray[position]==null)
		{
			return false;
		}
		else
		{
			return linearSearch(stringArray[position],input_string);    //if something is in the position check to make sure its not down the LinkedList
		}
	}

	/**
	 * Removes a given String from the HashMap if its in there
	 * 
	 * @param input_string      String to be removed
	 * @return                  1 if successfully removed, -1 if it was not successfully removed 
	 */
	public int remove(String input_string)
	{
		int hashcode = hashCode(input_string);
		int position = hashcode % (stringArray.length);
		if(stringArray[position]==null)                        //if nothing is there, do nothing
		{
			return -1;
		}
		else
		{
			if(contains(input_string))                             //if something is in there
			{
				Iterator<String> it =stringArray[position].iterator();     //get an iterator ready to traverse the LinkedList
				while(it.hasNext())                                        //while you haven't reached the end of the List 
				{
					String element=it.next();                              //grab an element
					if(element.equals(input_string))                       //if it equals what we are looking for
					{										
						it.remove();									    //remove it
						return 1; 
					}
					else
						continue;                                          //go to the next word
				}

			}
			return -1;                                                             //didnt find it
		}
	}

	/**
	 * Simple Linear Search
	 * 
	 * @param linkedList       LinkedList to be searched
	 * @param input_string	   String you are looking for
	 * @return
	 */
	private boolean linearSearch(LinkedList<String> linkedList, String input_string) {

		boolean isFound=false;              //variable indicating rather it was found

		for(String string:linkedList)        //loop using foreach
		{
			if(string.equals(input_string))  //if any element is qual to our string
			{
				isFound=true;                //set our flag to true
			}
			else
				continue;             //keep looking
		}
		return isFound;      //return flag
	}


	/**
	 * Displays the array 
	 */
	public void display()
	{
		for (Object value : stringArray)
		{
			System.out.println(value);
		}
		System.out.print("------------------------------------------------------\n");
	}
}
