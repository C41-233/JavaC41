
package c41.utility.collection;

import c41.utility.linq.*;

public interface IFloatCollection extends IFloatEnumerable{

	public boolean add(float value);
	
	public default void addAll(Iterable<Float> it){
		for(float val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
