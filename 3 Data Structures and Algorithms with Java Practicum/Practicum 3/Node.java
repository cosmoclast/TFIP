/******************************************************************************
### Practicum 03, Data Structure and Algorithm for Java ###
file  : Node.java
author: Alvin Yeo
edited by: <Yeo Beng Koon Bernard>
date  : 24/12/2021

***Refer CET1022_P03.pdf for instructions***
******************************************************************************/

/**
 * Generic Node class
 *
 * @param <K> - Key
 * @param <V> - Value
 */
class Node<K,V> {
    /**
     * Key
     */
	private K k;
    /**
	 * Value
	 */
	private V v;
	
    /**
	 * Constructor for the generic Node class
	 * @param key - Key of the Node
	 * @param value - Value of the Node
	 */
	public Node(K key, V value) {
		k = key;
		v = value;
	}
	
	/**
	 * Getter for the key of the Node
	 * @return returns the key of the Node
	 */
	public K getKey() {
		/* your code here */
		return this.k;
	}
    /**
     * Getter for the value of the Node
     * @return returns the value of the Node
     */
	public V getValue() {
		/* your code here */
		return this.v;
	}
	
    /**
     * Setter for the key of the Node
     * @param key - set the key of the Node
     */
	protected void setKey(K key) {
		/* your code here */
		this.k = key;
	}
    /**
	 * Setter for the value of the Node
	 * @param value - set the value of the Node
	 */
	protected void setValue(V value) {
		/* your code here */
		this.v = value;
	}
	
}
