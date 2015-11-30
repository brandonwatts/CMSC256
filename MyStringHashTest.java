package Assignment4;
/**
 * This program tests MyStringHash.java
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */

public class MyStringHashTest {


	public static void main(String[] args)
	{
		/**
		 * Create a HashMap of size 16
		 */
		MyStringHash hashmap = new MyStringHash(16);

		String[] test_names = {
				"John",
				"Anthony",
				"Matthew",
				"Carol",
				"Nicole",
				"Judith",
				"Betty",
				"Emily",
				"Barbara",
				"Julie",
				"Judith",
				"Diane",
				"Janice",
				"John",
				"Shawn",
				"Louise",
				"Craig",
				"Chris",
				"Todd",
				"Martha",
				"Lillian",
				"Patricia",
				"Gary",
				"Melissa",
				"Frank",
		};

		/**
		 * Add the test data to the hashMap
		 */
		for(String name:test_names)
			hashmap.add(name);

		/**
		 * Display the hashmap
		 */
		hashmap.display();

		/**
		 * Remove Todd and Chris and then display
		 */
		hashmap.remove("Todd");
		hashmap.remove("Chris");
		hashmap.display();

		/**
		 * Check if Gary is in the HashMap
		 */
		System.out.println("Gary is in the list: " + hashmap.contains("Gary"));

		/**
		 * Check if 4 is in the HashMap
		 */
		System.out.println("4 is in the list: " + hashmap.contains("4"));

	}
}
