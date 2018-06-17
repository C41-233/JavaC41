
package c41.utility.collection;

import c41.utility.linq.*;

public interface ILongCollection extends ILongEnumerable{

	public boolean add(long value);
	
	public default void addAll(Iterable<Long> it){
		for(long val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
