package all;

class Item {
	String name;
	int next;

	public Item(String name, int next) {
		this.name = name;
		this.next = next;
	}

	public String toString() {
		return "(" + name + "," + next + ")";
	}
}

public class ArrayLL {

	private Item[] all;
	private int numItems;
	private int front;
	private int[] avail;
	private int numAvail;

	// Constructor, initializes all data fields, to represent
	// an empty Item array linked list of length maxItems
	public ArrayLL(int maxItems) {

		all = new Item[maxItems];
		numItems = 0;
		front = -1;
		avail = new int[maxItems];
		numAvail = maxItems;
		int full = maxItems -1;
		

		for (int i = 0; i < maxItems; i++) {
			avail[i] = full;
			full--;
		}

		// COMPLETE THIS CONSTRUCTOR

	}

	// Adds a name to the front of this array linked list, in worst case O(1)
	// time,
	// and returns true.
	// Returns false if the array is full, in O(1) time
	public boolean addFront(String name) {

		if (numAvail == 0){
			return false;
		}
		
		if (numItems == 0) {
			Item temp = new Item(name, -1);
			all[0] = temp;
			numItems++;
			numAvail--;
			front = 0;
			avail[numAvail] = -1;
		} else {
			
			Item temp = new Item(name, front);
			all[avail[numAvail -1]] = temp;
			numItems++;
			numAvail--;
			front = avail[numAvail];
			avail[numAvail] = -1;
			

		}

		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

		return true;

	}

	// Deletes the name that is at the front this array linked list, in worst
	// case O(1) time,
	// and returns the deleted name
	// Returns null if the list is empty, in O(1) time
	public String deleteFront() {

		if (numItems == 0) {
			return null;
		}

		else {
			String delete = all[front].name;
			all[front] = null;
			numItems--;
			numAvail++;
			avail[numAvail - 1] = front;
			front--;
			return delete;
		}

		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

	}

	// Deletes the given name from this array linked list, and returns true.
	// Returns false if the name is not in the list.
	// Note: If there are n active items in the list, then this method must run
	// in
	// worst case O(n) time, i.e. time must not depend on the length of the all
	// array
	// (since the array might include available space not filled by active
	// items)
	// Also, avail array should be accessed/updated in O(1) time
	public boolean delete(String name) {

		if (numItems == 0){
			return false;
		}
		
		String tempName = name;
		int i;
		
		for (i = 0; i < numItems; i++){
			if((all[i].name).equals(tempName)){
				all[i] = null;
				break;
			}
		}
		
		for (int m = (i + 1); m < numItems; m ++) {
			all[m - 1] = all[m];
		}
		
		return true;
		
		
		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

	}

	// Checks if the given name is in this array linked list
	// Note: If there are n items in the list, then this method must run in
	// worst case O(n) time, i.e. time does not depend on the length of the all
	// array.
	public boolean contains(String name) {

		String tempName = name;
		for(int i =0; i < all.length; i++){
			
				if(all[i].name.equals(tempName)){
					return true;
				
			}
		}
		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

		return false;
	}

	// Prints the items in this array linked list in sequence from first to
	// last,
	// in worst case O(n) time where n is the number of items in the linked list
	// The list should be printed in a single line, separated by commas
	// Example: earth,mercury,venus
	// Make sure there aren't any extra commas in your output.
	// If the list is empty, you may print either nothing, or an empty string
	public void printList() {

		for (int i = 0; i < all.length; i++) {

			if (all[i] != null && all[i + 1] != null) {
				System.out.print(all[i].name + ",");

			}

			else if (all[i] != null && all[i + 1] == null) {
				System.out.print(all[i].name + ",");
			}

		}

		// COMPLETE THIS METHOD
	}

	// Prints all the entries in the main array (including unused spaces)
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printArray() {

		for (int i = 0; i < all.length; i++) {
			System.out.print(all[i] + ",");
		}

	}

	// Prints all the entries in the avail array that correspond to
	// available spaces in the main array
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printAvailableSpots() {

		for (int i = 0; i < avail.length; i++) {
			if (avail[i] >= 0) {
				System.out.println(avail[i]);
			}

		}
	}
}
