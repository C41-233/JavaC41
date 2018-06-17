
package  c41.utility.collection.set;

import java.util.HashSet;

public class FloatHashSet{

	private final HashSet<Float> set = new HashSet<>();

	public FloatHashSet(){
	
	}

	public boolean add(float value){
		return set.add(value);
	}

}