package c41.utility.linq;

import c41.utility.linq.enumerator.IEnumerator;

interface ISortedEnumerator<T> extends IEnumerator<T>{

	public boolean hasNextEquals();
	
}
