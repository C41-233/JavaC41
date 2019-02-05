
package c41.utility.collection;

import c41.utility.linq.*;

public interface IShortCollection extends IShortEnumerable{

	public boolean add(short value);
	
	public default void addAll(Iterable<Short> it){
		for(short val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
