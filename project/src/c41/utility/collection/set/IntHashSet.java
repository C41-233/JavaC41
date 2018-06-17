
package  c41.utility.collection.set;

import java.util.HashSet;

public class IntHashSet{

	private final HashSet<Integer> set = new HashSet<>();

	public IntHashSet(){
	
	}

	public boolean add(int value){
		return set.add(value);
	}

}