
package c41.utility.collection;

import c41.utility.linq.*;

public interface IByteCollection extends IByteEnumerable{

	public boolean add(byte value);
	
	public default void addAll(Iterable<Byte> it){
		for(byte val : it){
			add(val);
		}
	}
	
	public int size();
	
	@Override
	public default int count(){
		return size();
	}
	
}
