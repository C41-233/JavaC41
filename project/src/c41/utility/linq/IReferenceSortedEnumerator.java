package c41.utility.linq;

import c41.utility.linq.enumerator.IEnumerator;

interface IReferenceSortedEnumerator<T> extends IEnumerator<T>{

	public boolean hasNextEquals();
	
}
