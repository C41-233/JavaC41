
package c41.utility.collection;

import c41.utility.linq.*;

public interface IIntCollection extends IIntEnumerable{

	public boolean add(int value);
	
	public default void addAll(Iterable<Integer> it){
		for(int val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
