/******************************************************************************
### Practicum 03, Data Structure and Algorithm for Java ###
file  : KeyComparator.java
author: Alvin Yeo
date  : 24/12/2021

***DO NOT MODIFY THIS FILE***
***Refer CET1022_P03.pdf for instructions***
******************************************************************************/

import java.util.Comparator;

/**
 * Custom comparator class for comparing keys between 2 objects.
 * @param <E> - Keys of 2 objects of the same class type 
 */
class KeyComparator<E> implements Comparator<E> {
	@SuppressWarnings("unchecked")
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>)a).compareTo(b);
	}
}
