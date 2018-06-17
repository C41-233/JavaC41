
package c41.utility.collection;

import c41.utility.linq.*;

public interface ICharCollection extends ICharEnumerable{

	public boolean add(char value);
	
	public default void addAll(Iterable<Character> it){
		for(char val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
