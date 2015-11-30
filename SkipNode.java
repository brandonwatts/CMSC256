package Assignment4;
/**
 * This program represents a node in the MySkipList LinkedList
 * 
 * @author Brandon Watts
 * @version 1.0
 * @since 2015-11-10
 */

public class SkipNode
{
	/**
	 * Value to be stored
	 */
	private int value;

	/**
	 * pointers for the node
	 */
	private SkipNode up, down, left, right;

	/**
	 * Constructor for SkipNode
	 * 
	 * @param v
	 */
	public SkipNode(int v)
	{
		value = v;					// Add value to Node
		up = down = left = right = null;		// Set links to null
	}

	/**
	 * Getters and Setters
	 * 
	 */

	public int getKey() { 
		return value;
	}

	public void setKey(int key) { 
		this.value = key;
	}

	public SkipNode getUp() {
		return up;
	}

	public void setUp(SkipNode up) {
		this.up = up;
	}

	public SkipNode getDown() {
		return down;
	}

	public void setDown(SkipNode down) {
		this.down = down;
	}

	public SkipNode getLeft() {
		return left;
	}

	public void setLeft(SkipNode left) {
		this.left = left;
	}

	public SkipNode getRight() {
		return right;
	}

	public void setRight(SkipNode right) {
		this.right = right;
	}


}