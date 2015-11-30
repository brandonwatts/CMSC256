package Assignment4;
/**
 * This program implements the SkipList ADT on Integers
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */
import java.util.Random;

public class MySkipList
{

	/**
	 * Node to start the List
	 */
	private SkipNode head;

	/**
	 * Node to end the List
	 */
	private SkipNode tail;

	/**
	 * Integer variable to start 
	 */
	int negInf = Integer.MIN_VALUE;

	/**
	 * Integer variable to end
	 */
	int posInf = Integer.MAX_VALUE;

	/**
	 * Integer variables to store the height of the SkipList 
	 */
	private int height;

	/**
	 * Random variable to determine height of node
	 */
	private Random rand;

	/**
	 * Constructor for SkipList
	 */
	public MySkipList()
	{
		SkipNode p1 = new SkipNode(negInf);   //make a head node
		SkipNode p2 = new SkipNode(posInf);   //make a tail node

		head=p1;
		tail=p2;

		p1.setRight(tail);     //set right bound
		p2.setLeft(head);      //set left bound

		rand = new Random();	//Get random number
	}

	/**
	 * Searches SkipList for Integer
	 * 
	 * @param value     Integer you are looking for
	 * @return          returns value less than it if its there, the value if it is there 
	 */
	public SkipNode skipSearch(int value)
	{
		SkipNode p = head;

		while (true)       
		{
			while ((p.getRight().getKey() != posInf) && (p.getRight().getKey()>=value))   //make sure right is not tail and that the next value is greater than the one you are at
			{
				p = p.getRight(); //go right
			}

			if (p.getDown() != null)  //while you can go down
				p = p.getDown();      //go down
			else
				break;		//reached bottom and did not find it
		}

		return(p);         	
	}

	/**
	 * Removes a given Integer
	 * 
	 * @param value    Integer to be removed
	 * @return         True if successfully removed, false otherwise
	 */
	public boolean skipRemove(int value)
	{
		SkipNode p = skipSearch(value);

		if (p.getKey() != value)
			return false;         //we didnt find it

		while ( p != null )      //loop up the tower and shift pointers
		{
			p.getLeft().setRight(p.getRight());   //shift left pointer
			p.getRight().setLeft(p.getLeft());    //shift right pointer
			p=p.getUp(); 						 //move up tower
		}

		return true;
	}

	/**
	 * Adds a Integer value to the SkipList
	 * 
	 * @param value     Integer to be added
	 */
	public void skipInsert(int value)
	{
		int level;      //variable to store the level it will be placed
		SkipNode p, q;   //two SkipNodes- one is the value node, the other is the one less than the value node

		p = skipSearch(value);    //

		if(value==p.getKey())   //make sure its not already in there
			return;

		//fix the pointers
		q = new SkipNode(value);
		q.setLeft(p);
		q.setRight(p.getRight());
		p.getRight().setLeft(q);
		p.setRight(q);



		level = 0;
		while(rand.nextDouble() < 0.5)    //flip a coin and if "heads"
		{
			SkipNode e = new SkipNode(value);   //make a copy of our node

			if(level >= height)   //Check if height exceeds current level. If so, make a new level
			{
				SkipNode p1 = new SkipNode(negInf);   //make head for new level;
				SkipNode p2 = new SkipNode(posInf);   //make tail for new level

				height++;  //Increase height level

				//adjust pointers
				p1.setRight(p2);
				p1.setDown((SkipNode) head);
				p2.setLeft(p1);
				p2.setDown((SkipNode) tail);

				//adjust head and tail
				head.setUp((SkipNode) p1);
				tail.setUp((SkipNode) p2);
				head = (SkipNode) p1;
				tail = (SkipNode) p2;
			}

			while(p.getUp() == null)   //go back until we find a node that has a parent
				p = p.getLeft();

			p = p.getUp();   //make p the node less than the value on the top level

			//shift pointers
			e.setLeft(p);
			e.setRight(p.getRight());
			e.setDown(q);
			p.getRight().setLeft(e);
			p.setRight(e);
			q.setUp(e);

			q = e;  //make q the top node 

			level++;  //Increase level count 
		}
	}
}