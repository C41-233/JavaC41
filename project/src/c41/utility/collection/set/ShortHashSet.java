
package  c41.utility.collection.set;

import java.util.HashSet;

public class ShortHashSet{

	private final HashSet<Short> set = new HashSet<>();

	public ShortHashSet(){
	
	}

	public boolean add(short value){
		return set.add(value);
	}

}