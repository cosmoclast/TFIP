/******************************************************************************
### Practicum 03, Data Structure and Algorithm for Java ###
file  : MinHeapPriorityQueue.java
author: Alvin Yeo
edited by: <Yeo Beng Koon Bernard>
date  : 24/12/2021

***Refer CET1022_P03.pdf for instructions***
******************************************************************************/


import java.util.ArrayList;
import java.util.Comparator;

/**
 * Generic class for implementing the Priority Queue using the Minimum Heap method
 *
 * @param <K> - Key
 * @param <V> - Value
 */
public class MinHeapPriorityQueue<K,V> {
	
	/* ========= Do NOT modify anything within this line ========= */
    /**
     * ArrayList implementation of a heap
     */
	private ArrayList<Node<K,V>> heap = new ArrayList<>();
    /**
	 * Comparator object for the Key
	 */	
	private Comparator<K> comparator;
	
	/**
	 * Constructor for the Minimum Heap Priority Queue
	 */
	public MinHeapPriorityQueue() {
		comparator = new KeyComparator<K>();
	}
	
	/**
	 * Swap the entry at index i with index j of the ArrayList
	 * @param i - Node at index i
	 * @param j - Node at index j
	 */
	private void swap(int i, int j) {
		Node<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	/**
	 * Comparing two nodes according to its keys
	 * @param a - 1st Node to be compared
	 * @param b - 2nd Node to be compared
	 * @return a negative integer, zero, or a positive integer as the first argument is less than,
	 * equal to, or greater than the second.
	 */
	private int compare(Node<K,V> a, Node<K,V> b) {
		return comparator.compare(a.getKey(), b.getKey());
	}
	
	/* ========= Do NOT modify anything within this line ========= */ 
	
	/**************** TASK STARTS HERE ****************/
	// private utilities function

	/**
	 * Method to calculate the index of the parent node in the ArrayList
	 *
	 * @param j Index of child node in ArrayList
	 * @return Index of the parent node in the ArrayList
	 */
	private int parent(int j) {
		/* your code here */
		if(this.getSize() == 0)   //If heap has no nodes, return -1
			return -1;
		else if(j == 0)   //If index is root node, return -1
			return -1;
		else
			return ((j - 1) / 2);
	}

	/**
	 * Method to calculate the index of the left child node in the ArrayList
	 *
	 * @param j Index of parent node in ArrayList
	 * @return Index of the left child node in the ArrayList
	 */
	private int left(int j) {
		/* your code here */
		if(this.hasLeft(j))
			return 2 * j + 1;
		else
			return -1;
	}

	/**
	 * Method to calculate the index of the right child node in the ArrayList
	 *
	 * @param j Index of parent node in ArrayList
	 * @return Index of the right child node in the ArrayList
	 */
	private int right(int j) {
		/* your code here */
		if(this.hasRight(j))
			return 2 * j + 2;
		else
			return -1;
	}

	/**
	 * Method to check if a left child node exists
	 *
	 * @param j Index of parent node in ArrayList
	 * @return True if left child node exists. False if left child node does not exist
	 */
	private boolean hasLeft(int j) {
		/* your code here */
		if(this.getSize() <= 1)   //If heap only has root node or no nodes, return false
			return false;
		else if(j < 0)   //If index is negative number, return false
			return false;
		else if((2 * j + 1) >= this.getSize())   //If no left child, return false
			return false;
		else
			return true;
	}

	/**
	 * Method to check if a right child node exists
	 *
	 * @param j Index of parent node in ArrayList
	 * @return True if right child node exists. False if right child node does not exist
	 */
	private boolean hasRight(int j) {
		/* your code here */
		if(this.getSize() <= 1)   //If heap only has root node or no nodes, return false
			return false;
		else if(j < 0)   //If index is negative number, return false
			return false;
		else if((2 * j + 2) >= this.getSize())   //If no right child, return false
			return false;
		else
			return true;
	}

	/**
	 * Method to bubble up a parent node if key is smaller than parent node's key
	 *
	 * @param index Index of child node in ArrayList
	 */
	// moves the node at index 'index' higher, if necessary, to restore heap property
	private void bubbleup(int index) {
		/* your code here */
		int currIndex = index;

		//Loop continues if not at root node
		while(parent(currIndex) != -1) {
			//For case where parent node is bigger than child node, bubble up.
			if ((compare(this.heap.get(parent(currIndex)), this.heap.get(currIndex)) > 0)) {
				swap(parent(currIndex), currIndex);
				currIndex = parent(currIndex);
			} else {
				return;
			}
		}
	}

	/**
	 * Method to bubble down a parent node if key is smaller than child node's key.
	 * Will bubble down the left child node if left and right child node is equal, or
	 * if only left child node exists, otherwise bubble down the smaller of the
	 * 2 child nodes.
	 *
	 * @param index Index of parent node in ArrayList
	 */
	// moves the node at index 'index' lower, if necessary, to restore heap property
	private void bubbledown(int index) {
		/* your code here */
		int currIndex = index;

		//Loop continues if not at lowest level
		while (hasLeft(currIndex)) {
			int checkIndex = left(currIndex);
			//For 2 child node case
			if (hasRight(currIndex)) {
				//Check if left child node larger than right child node
				if (compare(this.heap.get(left(currIndex)), this.heap.get(right(currIndex))) > 0)
					checkIndex = right(currIndex);
			}
			//Check if child node is larger than parent node
			if (compare(this.heap.get(currIndex), this.heap.get(checkIndex)) <= 0) {
				return;
			} else {
				swap(currIndex, checkIndex);
				currIndex = checkIndex;
			}
		}
	}

	// public methods
	/**
	 * Getter for number of nodes in heap
	 *
	 * @return Number of nodes in heap
	 */
	// return the number of nodes in the heap
	public int getSize() {
		/* your code here */
		return this.heap.size();
	}

	/**
	 * Method to print out each node's key value in ArrayList
	 */
	// prints the key of the node in format -> eg. 1 3 2 7 19 26
	public void displayQueue() {
		/* your code here */
		for(int i = 0; i < getSize(); i++)
			System.out.print(heap.get(i).getKey() + " ");
		System.out.println();
	}

	/**
	 * Method to peek at the Node located at the root of the heap, does not remove
	 * the root Node.
	 *
	 * @return Root Node
	 */
	// returns the Node located at root, but does not remove the Node
	public Node<K,V> peekMin() {
		/* your code here */
		if(this.getSize() == 0)
			return null;
		else
			return heap.get(0);
	}

	/**
	 * Method to insert new Node to heap, uses bubbleup() method to ensure
	 * Node with smallest key is at root Node
	 *
	 * @param key Key
	 * @param value Value
	 * @return Node added to heap
	 */
	// insert new Node to the heap, uses the bubbleup() method
	public Node<K,V> insert(K key, V value) {
		/* your code here */
		Node<K,V> newNode = new Node<>(key, value);

		this.heap.add(this.getSize(), newNode);
		bubbleup(this.getSize() - 1);
		return newNode;
	}

	/**
	 * Method to remove root Node from heap, uses bubbledown() method to ensure
	 * Node with smallest key is at root Node
	 *
	 * @return Node remove from heap
	 */
	// deletes the Node at root, uses the bubbledown() method
	public Node<K,V> removeMin() {
		/* your code here */
		if (this.getSize() == 0) {
			return null;
		} else if (this.getSize() == 1) {
			return this.heap.remove(0);
		} else {
			//Removal of root and replacing with last node
			Node<K, V> lastNode = this.heap.remove(getSize() - 1);
			Node<K, V> tempNode = this.heap.get(0);

			this.heap.set(0, lastNode);
			bubbledown(0);
			return tempNode;
		}
	}

	public void displayQueue2() {
			//* your code here *//
		for(int i = 0; i < getSize(); i++)
			System.out.println(heap.get(i).getKey() + " " + heap.get(i).getValue());
	}
	/**************** TASK ENDS HERE ****************/
}
