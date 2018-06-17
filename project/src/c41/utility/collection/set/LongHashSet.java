
package  c41.utility.collection.set;

import java.util.HashSet;

public class LongHashSet{

	private final HashSet<Long> set = new HashSet<>();

	public LongHashSet(){
	
	}

	public boolean add(long value){
		return set.add(value);
	}

}