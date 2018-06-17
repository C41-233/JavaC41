
package c41.utility.collection;

import c41.utility.linq.*;

public interface IDoubleCollection extends IDoubleEnumerable{

	public boolean add(double value);
	
	public default void addAll(Iterable<Double> it){
		for(double val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
