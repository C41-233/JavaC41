
package  c41.utility.collection.set;

import java.util.HashSet;

public class ByteHashSet{

	private final HashSet<Byte> set = new HashSet<>();

	public ByteHashSet(){
	
	}

	public boolean add(byte value){
		return set.add(value);
	}

}